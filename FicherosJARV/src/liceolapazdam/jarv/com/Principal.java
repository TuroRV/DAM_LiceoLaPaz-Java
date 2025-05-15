package liceolapazdam.jarv.com;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        do {
            escribirMenu();
            int opcion;
            try {
                opcion = leerOpcion();
            } catch (InputMismatchException e) {
                System.out.println("La opción tiene que ser un número entero: ");
                continue;
            }
            switch (opcion) {
                case 0: 
                    System.exit(0);
                case 1:
                    System.out.println("Escriba la ruta del fichero: ");
                    String ruta = leerRuta();
                    String contenido = leerFicheroTexto(ruta);
                    if (contenido != null) {
                        System.out.println(contenido);
                    }
                    break;
                case 2:
                    escribirSubMenu();
                    try {
                        opcion = leerOpcion();
                    } catch (InputMismatchException e) {
                        System.out.println("La opción tiene que ser un número entero: ");
                        continue;
                    }
                    switch (opcion) {
                        case 1:
                            System.out.println("Escriba la ruta del fichero de origen:");
                            String rutaOrigenTexto = leerRuta();
                            System.out.println("Escriba la ruta del fichero de destino");
                            String rutaDestinoTexto = leerRuta();
                            copiarFicheroTexto(rutaOrigenTexto,rutaDestinoTexto);
                            break;
                        case 2:
                            System.out.println("Escriba la ruta del fichero de origen:");
                            String rutaOrigenBinario = leerRuta();
                            System.out.println("Escriba la ruta del fichero de destino");
                            String rutaDestinoBinario = leerRuta();
                            copiarFicheroBinario(rutaOrigenBinario,rutaDestinoBinario);
                            break;
                        case 0:
                            break;
                        default:
                            System.out.println("Opción no válida: ");
                    }
                    break;
                case 3:
                    System.out.println("Escriba la ruta de la carpeta: ");
                    String rutaCarpeta = leerRuta();
                    listarFichero(rutaCarpeta);
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        } while (true);
    }

    private static void listarFichero(String ruta) {
        File carpeta = new File(ruta);
        if (!carpeta.isDirectory()) {
            System.out.println("La ruta no es una carpeta");
            return;
        }
        File[] nombresFicheros = carpeta.listFiles();
        for (int i = 0; i < nombresFicheros.length; i++) {
            System.out.println(nombresFicheros[i].getName() + "\t" + (nombresFicheros[i].length() / 1024.0) + "Kbs");
        }
    }

    private static void copiarFicheroBinario(String rutaOrigen, String rutaDestino) {
        byte[] contenido = leerFicheroBinario(rutaOrigen);
        if (contenido == null) {
            System.out.println("Error al leer el fichero de origen");
            return;
        }
        escribirFicheroBinario(contenido,rutaDestino);
    }

    private static void escribirFicheroBinario(byte[] contenido, String rutaDestino) {
        try {
            FileOutputStream fos = new FileOutputStream(rutaDestino);
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            bos.write(contenido);
            bos.close();
            fos.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error al escribir fichero binario");
        } catch (IOException e) {
            System.out.println("Error al escribir fichero binario");
        }
    }

    private static byte[] leerFicheroBinario(String rutaOrigen) {
        byte[] contenido = null;
        File fichero = new File(rutaOrigen);
        if (!fichero.isFile()) {
            System.out.println("La ruta " + rutaOrigen + " no existe.");
            return contenido;
        }
        contenido = new byte[(int) fichero.length()];
        byte[] buffer = new byte[1024];
        int posicion = 0;
        try {
            FileInputStream fis = new FileInputStream(fichero);
            BufferedInputStream bis = new BufferedInputStream(fis);
            int numBytesLeidos = bis.read(buffer);
            while (numBytesLeidos != -1) {
                for (int i = 0; i < numBytesLeidos; i++) {
                    contenido[posicion] = buffer[i];
                    posicion++;
                }
                numBytesLeidos = bis.read(buffer);
            }
            bis.close();
            fis.close();
            return contenido;
        } catch (FileNotFoundException e) {
            System.out.println("La ruta no existe");
        } catch (IOException e) {
            System.out.println("Error al leer el fichero de origen");
            return null;
        }
        return contenido;
    }

    private static void copiarFicheroTexto(String rutaOrigen, String rutaDestino) {
        String contenido = leerFicheroTexto(rutaOrigen);
        if (contenido == null) {
            System.out.println("Error al leer el fichero de origen");
            return;
        }
        escribirFicheroTexto(contenido,rutaDestino);
    }

    private static void escribirFicheroTexto(String contenido, String rutaDestino) {
        try {
            FileWriter fw = new FileWriter(rutaDestino);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            pw.print(contenido);
            pw.close();
            bw.close();
            pw.close();
        } catch (IOException e) {
            System.out.println("Error al escribir el fichero de destino");
        }
    }

    private static void escribirSubMenu() {
        System.out.println("Tipo de fichero a copiar\n" +
                "1. Fichero de texto\n" +
                "2. Fichero binario\n" +
                "0. Cancelar\n" +
                "Escoja una opción:");
    }

    private static String leerFicheroTexto(String ruta) {
        String contenido = "";
        File fichero = new File(ruta);
        if (!fichero.isFile()) {
            System.out.println("La ruta " + ruta + " no existe.");
            return null;
        }
        Scanner sc = null;
        try {
            sc = new Scanner(fichero);
        } catch (FileNotFoundException e) {
            System.out.println("La ruta " + ruta + " no existe.");
        }
        while (sc.hasNextLine()) {
            contenido += sc.nextLine() + "\n";
        }
        sc.close();
        return contenido;
    }

    private static String leerRuta() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    private static int leerOpcion() {
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    private static void escribirMenu() {
        System.out.println("FICHEROS\n" +
                "1. Leer fichero de texto\n" +
                "2. Copiar fichero\n" +
                "3. Listar archivos de directorio\n" +
                "0. Salir\n" +
                "Escoja una opción:");
    }
}
