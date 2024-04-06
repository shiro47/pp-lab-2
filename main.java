import java.util.Scanner;
import java.util.ArrayList;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Podaj liczbę uczniów: ");
        int liczbaUczniow = scanner.nextInt();

        System.out.print("Podaj liczbę przedmiotów: ");
        int liczbaPrzedmiotow = scanner.nextInt();

        ArrayList<double[]> listaOcen = dodajOceny(scanner, liczbaUczniow, liczbaPrzedmiotow);
        wyswietlOcenyISrednie(listaOcen, liczbaPrzedmiotow);
    }

    public static ArrayList<double[]> dodajOceny(Scanner scanner, int liczbaUczniow, int liczbaPrzedmiotow) {
        ArrayList<double[]> listaOcen = new ArrayList<>();
        for (int i = 0; i < liczbaUczniow; i++) {
            double[] ocenyUcznia = new double[liczbaPrzedmiotow];
            for (int j = 0; j < liczbaPrzedmiotow; j++) {
                System.out.print("Podaj ocenę ucznia " + (i + 1) + " z przedmiotu " + (j + 1) + ": ");
                ocenyUcznia[j] = scanner.nextDouble();   
            }
            listaOcen.add(ocenyUcznia);
        }
        return listaOcen;
    }

    public static void wyswietlOcenyISrednie(ArrayList<double[]> listaOcen, int liczbaPrzedmiotow) {
        for (int i = 0; i < listaOcen.size(); i++) {
            double[] ocenyUcznia = listaOcen.get(i); 
            double sumaOcen = 0;
            for (int j = 0; j < liczbaPrzedmiotow; j++) {
                sumaOcen += ocenyUcznia[j];
            }
            double sredniaOcen = sumaOcen / liczbaPrzedmiotow;
            System.out.println("Oceny ucznia " + (i + 1) + ": " + java.util.Arrays.toString(ocenyUcznia));
            System.out.println("Średnia ocen ucznia " + (i + 1) + ": " + sredniaOcen);
        }
    }
}
