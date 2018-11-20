package pl.kobietydokodu.catsdatabase;

public class Interfejs {

//    static Scanner sc = new Scanner(System.in);
//
//    public static String getUserInput() {
//        return sc.nextLine();
//    }

    public static void main(String[] args) {

//        System.out.println("Podaj imie: ");
//        String imieWczytaneOdUzytkownika = getUserInput();
//
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/mm/yyyyy");
//        Date date = null;
//        try {
//            date = simpleDateFormat.parse("12/05/2017");
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        Kot kot = new Kot("Mruczek", date, 5.5f, "Anna");
//        Kot kot2 = new Kot("Azorek", date, 10f, "Krzysio Misio");
//        Kot kot3 = new Kot("Peszek", date, 15f, "Gosia");
//        KotDAO listaKotow = new KotDAO();
//        listaKotow.dodajKota(kot);
//        listaKotow.dodajKota(kot2);
//        KotDAO listaKotow2 = new KotDAO();
//        listaKotow2.dodajKota(kot3);
//        for (int i = 0; i < listaKotow.getListaKotow().size(); i++) {
//            System.out.println(listaKotow2.getListaKotow().get(i).sayHello());
//        }

//        Scanner opcjaMenu = new Scanner(System.in);
//
//        while (true) {
//            wyswietlMenu();
//            obslugaMenu(opcjaMenu.nextInt());
//        }
//    }
//
//    private static void wyswietlMenu() {
//        System.out.println("MENU");
//        System.out.println("1. Dodaj kota");
//        System.out.println("2. Wyświetl wszystkie cats");
//        System.out.println("3. Zamknij");
//    }
//
//    private static void obslugaMenu(Integer wybranaOpcja) {
//        KotDAO listaZKotami = new KotDAO();
//        Scanner listaKotow = new Scanner(System.in);
//        Integer nrKota;
//        switch (wybranaOpcja) {
//            case 1:
//                listaZKotami.dodajKota(nowyKot());
//                break;
//            case 2:
//                listaZKotami.toString();
//                nrKota = listaKotow.nextInt();
//                try {
//                    System.out.println(listaZKotami.getListaKotow().get(nrKota - 1).sayHello());
//                } catch (IndexOutOfBoundsException ex) {
//                    System.out.println("Brak kota o podanym numerze");
//                }
//                break;
//            case 3:
//                System.exit(0);
//                break;
//            default:
//                System.out.println("Brak wybranej opcji");
//                break;
//        }
//    }
//
//    private static Kot nowyKot() {
//        Scanner scanner = new Scanner(System.in);
//        System.out.print("Podaj imie kota: ");
//        String imieKota = scanner.nextLine();
//        System.out.print("Podaj imie opiekuna: ");
//        String opiekun = scanner.nextLine();
//
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-MM-DD");
//        Date date = null;
//        Pattern pattern = Pattern.compile("\\d{4}-\\d{2}-\\d{2}");
//        Matcher matcher;
//        String waga;
//String dataUrodzenia;
//        do {
//            System.out.print("Podaj date urodzenia kota: ");
//            dataUrodzenia = scanner.nextLine();
//            matcher = pattern.matcher(dataUrodzenia);
//            if (matcher.matches() == true) {
//                try {
//                    date = simpleDateFormat.parse(dataUrodzenia);
//                } catch (ParseException e) {
//                    System.out.print("Podaj date urodzenia kota: ");
//                    dataUrodzenia = scanner.nextLine();
//                }
//            }
//        } while (date == null);
//
//        Float waga2 = null;
//        do {
//            System.out.print("Podaj wage kota: ");
//            waga = scanner.nextLine();
//            try {
//                waga2 = Float.parseFloat(waga);
//            } catch (NumberFormatException e) {
//                System.out.print("Podaj wage kota: ");
//                waga = scanner.nextLine();
//            }
//        } while (waga2 == null);
//
//        Kot kot = new Kot();
//        kot.setName(imieKota);
//        kot.setKeeper(opiekun);
//        kot.setDateOfBirth(date);
//        kot.setWeight(waga2);
//        return kot;
    }
}
