package com.liceolapaz.dam.jarv;

import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        do {
            showMenu();
            int option;
            try {
                option = readInt();
            } catch (InputMismatchException e) {
                System.out.println("La opción debe ser un número entero");
                continue;
            }
            switch (option) {
                case 0:
                    System.out.println("Cerrando aplicación");
                    System.exit(0);
                    break;
                case 1:
                    System.out.println("Introduzca la ruta del archivo a leer: ");
                    String path = readString();
                    ArrayList<String> content = readFile(path);
                    if (content != null) {
                        System.out.println(content);
                    }
                    break;
                case 2:
                    showMenu2();
                    try {
                    option = readInt(); } catch (InputMismatchException e) {
                        System.out.println("La opción debe ser un número entero");
                    }
                    switch (option) {
                        case 0:
                            break;
                        case 1:
                            System.out.println("Escriba la ruta del fichero de origen: ");
                            String textSourcePath = readString();
                            System.out.println("Escriba la ruta del fichero de destino");
                            String textTargetPath = readString();
                            copyTextFile(textSourcePath,textTargetPath);
                            break;
                        case 2:
                            System.out.println("Introduzca la ruta de origen del fichero binario: ");
                            String binarySourcePath = readString();
                            System.out.println("Introduzca la ruta de destino del fichero binario: ");
                            String binaryTargetPath = readString();
                            copyBinaryFile(binarySourcePath,binaryTargetPath);
                            break;
                    }
                    break;
                case 3:
                    System.out.println("Escriba la ruta de la carpeta");
                    String filePath = readString();
                    listFiles(filePath);
                    break;
            }
        } while (true);
    }

    private static void listFiles(String filePath) {
        File file = new File(filePath);
        if (!file.isDirectory()) {
            System.out.println("La ruta especificada no es una carpeta");
        }
        File[] files = file.listFiles();
        for (int i = 0; i < files.length; i++) {
            System.out.println(files[i].getName() + "\t" + files[i].length() + " bytes");
        }
    }

    private static void copyBinaryFile(String binarySourcePath, String binaryTargetPath) {
        ArrayList<Byte> bytes = readBinaryFile(binarySourcePath);
        writeBinaryFile(bytes,binaryTargetPath);
    }

    private static void writeBinaryFile(ArrayList<Byte> bytes, String binaryTargetPath) {
        try {
            FileOutputStream fos = new FileOutputStream(binaryTargetPath);
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            for (Byte aByte : bytes) {
                bos.write(aByte);
            }
            bos.close();
            fos.close();
        } catch (FileNotFoundException e) {
            System.out.println("Ruta no encontrada");
        } catch (IOException e) {
            System.out.println("Error escribiendo fichero");
        }
    }

    private static ArrayList<Byte> readBinaryFile(String binarySourcePath) {
        ArrayList<Byte> content =  null;
        File file = new File(binarySourcePath);
        if (!file.isFile()) {
            System.out.println("La ruta " + binarySourcePath + " no existe.");
            return content;
        }
        content = new ArrayList<>();
        byte[] buffer = new byte[1024];
        try {
            FileInputStream fis = new FileInputStream(binarySourcePath);
            BufferedInputStream bis = new BufferedInputStream(fis);
            int bytesRead = bis.read(buffer);
            System.out.println(bytesRead);
            while (bytesRead != -1) {
                for (int i = 0; i < bytesRead; i++) {
                    content.add(buffer[i]);
                }
                bytesRead = bis.read(buffer);
            }
            fis.close();
            bis.close();
        } catch (FileNotFoundException e) {
            System.out.println("La ruta no existe");
        } catch (IOException e) {
            System.out.println("Error leyendo fichero");
        };
        return content;
    }

    private static void copyTextFile(String sourcePath, String targetPath) {
        ArrayList<String> content = readFile(sourcePath);
        if (content == null) {
            System.out.println("Error al leer el fichero de origen o fichero vacío.");
        }
        writeTextFile(content, targetPath);
    }

    private static void writeTextFile(ArrayList<String> content, String targetPath) {
        try {
            FileWriter fw = new FileWriter(targetPath);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
           for (int i=0; i<content.size(); i++) {
               pw.println(content.get(i));
           }
            pw.close();
            bw.close();
            fw.close();
        } catch (IOException e) {
            System.out.println("Error al escribir en el fichero de destino.");
        }

    }

    private static void showMenu2() {
        System.out.println("Tipo de fichero a copiar\n" +
                "1. Fichero de texto\n" +
                "2. Fichero binario\n" +
                "0. Cancelar\n" +
                "Escoja una opción:");
    }

    private static ArrayList<String> readFile(String path) {
        ArrayList<String> content = new ArrayList<>();
        File file = new File(path);
        Scanner sc = null;

        if (!file.isFile()) {
            System.out.println("La ruta " + path + " no existe.");
            return null;
        }

        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println("La ruta " + path + " no existe.");
        }

        while (sc.hasNextLine()) {
            content.add(sc.nextLine());
        }

        return content;
    }

    private static String readString() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    private static int readInt() {
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    private static void showMenu() {
        System.out.println("FICHEROS\n" +
                "1. Leer fichero de texto\n" +
                "2. Copiar fichero\n" +
                "3. Listar archivos de directorio\n" +
                "0. Salir\n" +
                "Escoja una opción:");
    }
}
