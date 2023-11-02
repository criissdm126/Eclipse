package AAD.UD02E04.CristinaDeMaria;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Principal {

    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Error, debe proporcionar un argumento que sea el nombre del archivo de texto.");
            return;
        }

        String archivoTexto = args[0];
        File fichero = new File(archivoTexto);

        if (!fichero.exists()) {
            System.err.println("Error, el archivo de texto no existe.");
            return;
        }

        List<Modulo> modulos = new ArrayList<>();
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;

        try {
            fileReader = new FileReader(archivoTexto);
            bufferedReader = new BufferedReader(fileReader);
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                String[] datos = line.split("\\|");
                String nombre = datos[0];
                int horas = Integer.parseInt(datos[1]);
                String profesor = datos[2];
                int curso = Integer.parseInt(datos[3]);
                Modulo modulo = new Modulo(nombre, horas, curso, profesor);
                modulos.add(modulo);
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.err.println("Error, fichero inexistente.");
        } catch (IOException e) {
            System.err.println("Error durante la manipulación del fichero.");
        } finally {
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                if (fileReader != null) {
                    fileReader.close();
                }
            } catch (IOException e) {
                System.err.println("Error al cerrar los recursos de lectura.");
            }
        }

        File archivoBinario = new File("modulos.dat");
        if (archivoBinario.exists()) {
            System.err.println("Error, el archivo binario ya existe. No se realizará la escritura.");
        } else {
            ObjectOutputStream objectOutputStream = null;
            FileOutputStream fileOutputStream = null;

            try {
                fileOutputStream = new FileOutputStream(archivoBinario);
                objectOutputStream = new ObjectOutputStream(fileOutputStream);

                for (Modulo modulo : modulos) {
                    objectOutputStream.writeObject(modulo);
                }
            } catch (IOException e) {
                System.err.println("Error durante la escritura en el archivo binario.");
            } finally {
                try {
                    if (objectOutputStream != null) {
                        objectOutputStream.close();
                    }
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                } catch (IOException e) {
                    System.err.println("Error al cerrar los recursos de escritura.");
                }
            }
        }
    }
}



/* Módulo profesional|horas semanales|profesor|curso|contraseña AV
 * Bases de datos|6|José|1|DAM23fn3-a$
 * Entornos de desarrollo|3|Salvador|1|DAM23fn3-a$
 * Acceso a datos|6|José|2|DAM23fn3-a$
 * Programación de servicios y procesos|4|Agustín|2|DAM23fn3-a$
 * Programación|8|Salvador|1|DAM23fn3-a$
 * Desarrollo web en entorno servidor|9|Vicky|2|DAW23fn3-a$
 * Sistemas informáticos|6|Llanos|1|DAM23fn3-a$
 */
