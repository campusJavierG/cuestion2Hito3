import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


public class Cuestion2 {
    public static void main(String[] args) throws IOException {
        String direccion = "C:/Users/Campus FP/actividad2Hito3/src/preguntas";
        List<String> lista = new ArrayList<>();

        try (FileReader fr = new FileReader(direccion);
             BufferedReader br = new BufferedReader(fr)) {
            String linea;

            while ((linea = br.readLine()) != null) {
                lista.add(linea);
            }

            System.out.println("Cantidad de registros: " + lista.size());

            String[] arreglo = new String[lista.size()];
            for (int i = 0; i < lista.size(); i++) {
                arreglo[i] = lista.get(i);

            }

            String[] preguntas = new String[arreglo.length/2 ];
            String[] respuestas = new String[arreglo.length/2 ];
            int j = 0;
            int h = 0;
            for (int i = 0; i < arreglo.length; i++) {
                if (i % 2 != 0) {
                    respuestas[j] = arreglo[i];
                    j++;
                } else {
                    preguntas[h] = arreglo[i];
                    h++;
                }
            }
            System.out.println("Test de preguntas y respuestas");
            Scanner sc = new Scanner(System.in);
            int respuesta;
            int aciertos =0;
            int MAX = 10;
            ArrayList<Integer> numerosAleatorios = new ArrayList<Integer>();
            for (int i=0;i<10;i++) {
                numerosAleatorios.add(i);
            }
            Collections.shuffle(numerosAleatorios);
            int k=0;
            for (int i=0;i< preguntas.length;i++){


                System.out.println((i+1)+"º pregunta");

                System.out.println(preguntas[numerosAleatorios.get(k)]);
                respuesta= sc.nextInt();


                if (respuesta==Integer.parseInt(respuestas[numerosAleatorios.get(k)])){
                    System.out.println("Has acertado");
                    aciertos++;
                    k++;
                }else {
                    System.out.println("Has fallado");
                    k++;
                }


            }
            System.out.println("Tu nota es "+aciertos+"/10");

        }catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }


        }
    }
