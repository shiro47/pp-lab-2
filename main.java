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
              double ocena;
              do {
                  System.out.print("Podaj ocenę ucznia " + (i + 1) + " z przedmiotu " + (j + 1) + ": ");
                  ocena = scanner.nextDouble();
                  if (ocena <= 0 || ocena >= 6) {
                      System.out.println("Błędna ocena! Podaj dodatnią ocenę mniejszą niż 6.");
                  }
              } while (ocena <= 0 || ocena >= 6);
              ocenyUcznia[j] = ocena;   
          }
          listaOcen.add(ocenyUcznia);
      }
      return listaOcen;
  }

    private static double obliczSrednia(double[] ocenyUcznia) {
      double sumaOcen = 0;
      for (double ocena : ocenyUcznia) {
          sumaOcen += ocena;
      }
      return sumaOcen / ocenyUcznia.length;
  }
    private static double obliczMediane(double[] ocenyUcznia) {
      java.util.Arrays.sort(ocenyUcznia);
      int iloscOcen = ocenyUcznia.length;
      if (iloscOcen % 2 != 0) { //nieparzysta
          return ocenyUcznia[iloscOcen / 2];
      } else { //parzysta
          double mediana1 = ocenyUcznia[iloscOcen / 2 - 1];
          double mediana2 = ocenyUcznia[iloscOcen / 2];
          return (mediana1 + mediana2) / 2;
    }
  }


    public static void wyswietlOcenyISrednie(ArrayList<double[]> listaOcen, int liczbaPrzedmiotow) {
      for (int i = 0; i < listaOcen.size(); i++) {
        double[] ocenyUcznia = listaOcen.get(i); 
        double sumaOcenUcznia = 0;
            for (double ocena : ocenyUcznia) {
                sumaOcenUcznia += ocena;
            };
        System.out.println("Oceny ucznia " + (i + 1) + ": " + java.util.Arrays.toString(ocenyUcznia));
        System.out.println("Suma ocen ucznia " + (i + 1) + ": " + sumaOcenUcznia);
        System.out.println("Średnia ocen ucznia " + (i + 1) + ": " + obliczSrednia(ocenyUcznia));
        System.out.println("Mediana ocen ucznia " + (i + 1) + ": " + obliczMediane(ocenyUcznia));
    }
    }

}
