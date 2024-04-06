import java.util.Scanner;

public class main {
  public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Podaj liczbę uczniów: ");
        int liczbaUczniow = scanner.nextInt();

        System.out.print("Podaj liczbę przedmiotów: ");
        int liczbaPrzedmiotow = scanner.nextInt();

        double[][] oceny = new double[liczbaUczniow][liczbaPrzedmiotow];

        for (int i = 0; i < liczbaUczniow; i++) {
            for (int j = 0; j < liczbaPrzedmiotow; j++) {
                System.out.print("Podaj ocenę ucznia " + (i + 1) + " z przedmiotu " + (j + 1) + ": ");
                oceny[i][j] = scanner.nextDouble();
            }
        }

        for (int i = 0; i < liczbaUczniow; i++) {
            double sumaOcen = 0;
            for (int j = 0; j < liczbaPrzedmiotow; j++) {
                sumaOcen += oceny[i][j];
            }
            double sredniaOcen = sumaOcen / liczbaPrzedmiotow;
            System.out.println("Średnia ocen ucznia " + (i + 1) + ": " + sredniaOcen);
    }
  }}