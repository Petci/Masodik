package masodik;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.IntSummaryStatistics; //??
import java.util.List; //??
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors; //??

interface Filter{
    boolean function(int n);
}

interface Comperegy23{
    boolean function(int x, int y);
}

class Gepjarmu{
    String rendszam;
    Integer gyartasiEv;
    String gyartmany;

    public Gepjarmu(String rendszam, Integer gyartasiEv, String gyartmany) {
        this.rendszam = rendszam;
        this.gyartasiEv = gyartasiEv;
        this.gyartmany = gyartmany;
    }

    @Override
    public String toString() {
        return rendszam + ", " + gyartasiEv + ", " + gyartmany;
    }
    
}

class Osztalygy31{
    String neptunkod;
    String nev;
    String varos;
    Integer eletkor;
    int[] osztályzat = new int[4];
    
    public Osztalygy31(String neptunkod, String nev, String varos, Integer eletkor, int[] osztályzat){
        this.neptunkod = neptunkod;
        this.nev = nev;
        this.varos = varos;
        this.eletkor = eletkor;
        this.osztályzat = osztályzat;
    }
    
    @Override
    public String toString() {
        return neptunkod + ", " + nev + ", " + varos + ", " + eletkor + ", " + "Matematika: " + osztályzat[0] + ", " + "Történelem: " + osztályzat[1] + ", " + "Irodalom: " + osztályzat[2] + ", " + "Hittan: " + osztályzat[3];
    }
}

class kurzusHallgatoigy32{
    String neptunkod;
    String nev;
    String varos;
    Integer eletkor;
    int[] osztályzat = new int[4];
    
    public kurzusHallgatoigy32(String neptunkod, String nev, String varos, Integer eletkor, int[] osztályzat){
        this.neptunkod = neptunkod;
        this.nev = nev;
        this.varos = varos;
        this.eletkor = eletkor;
        this.osztályzat = osztályzat;
    }
    
    @Override
    public String toString() {
        return neptunkod + ", " + nev + ", " + varos + ", " + eletkor + ", " + "Matematika: " + osztályzat[0] + ", " + "Történelem: " + osztályzat[1] + ", " + "Irodalom: " + osztályzat[2] + ", " + "Hittan: " + osztályzat[3];
    }
}





public class Masodik {

    public static void main(String[] args) {
        Random rnd = new Random();
        Scanner scan = new Scanner(System.in);
        
        //Első óra: Tömblisták
        
        int a1 = 10;
        Integer b1 = 15;
        System.out.println(a1+b1);
        
        ArrayList<Integer> szamok11 = new ArrayList<>();
        szamok11.add(5);
        szamok11.add(2);
        szamok11.add(20);
        szamok11.add(0, 12);
        System.out.println(szamok11);
        
        System.out.println(szamok11.get(1));
        szamok11.set(2, 14);
        szamok11.remove(1);
        System.out.println(szamok11);
        
        ArrayList<Integer> szamok12 = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++) {
            szamok12.add(rnd.nextInt(100)+1);
        }
        System.out.println(szamok12);
        ArrayList<Integer> parosSzamok11 =  kivalogatParosok1(szamok12);
        System.out.println(parosSzamok11);
        
        //Gyakorlás 1
        /*
        1. Hozz létre egy egész számokat tároló tömblistát számok néven. 
            a) adj hozzá 5 számot, 
            b) szúrj be a második elem után egy számot, 
            c) töröld a tömblista utolsó elemét, 
            d) írd ki a konzolra a tömblista harmadik elemét.*/
        
        ArrayList<Integer> szamokgy11 = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            szamokgy11.add(rnd.nextInt(10)+1);
        }
        szamokgy11.add(2, 7);
        szamokgy11.remove(szamokgy11.size()-1);
        System.out.println(szamokgy11.get(2));
        
        /*
        2. Hozz létre neveket tárló tömblistát nevek néven. 
            a) Írj neveket a listába. (Pisti, Mari, Józsi, Lali), 
            b) Írd ki a konzolra a második név első karakterét! Pl. M*/
        
        ArrayList<String> nevekgy12 = new ArrayList<>();
        nevekgy12.add("Pisti");
        nevekgy12.add("Mari");
        nevekgy12.add("Józsi");
        nevekgy12.add("Lali");
        System.out.println((nevekgy12.get(1)).charAt(0));
        
        /*
        3. Tölts fel egy egész számokat tartalmazó tömblistát véletlenszámokkal a 20 és 80 intervallumban! 
            a) Írd ki a páratlan számokat. 
            b) Töröld belőle a páratlan számokat.*/
        
        ArrayList<Integer> szamokgy13 = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            szamokgy13.add(rnd.nextInt(60)+21);
        }
        for (int i = 0; i < szamokgy13.size(); i++) {
            int szamgy13 = szamokgy13.get(i);
            if (szamgy13 % 2 == 1) {
                System.out.println(szamgy13);
            }
        }
        for (int i = 0; i < szamokgy13.size(); i++) {
            if (szamokgy13.get(i)%2==1) {
                szamokgy13.remove(i);
            }
        }
        
        /*
        4. Tekintsd át az előzőekben tanult programozási tételeket és próbáld átírni őket tömblistára!
        */
        
        /*
        5. Kérj be a felhasználótól neveket egy tömblistába, egészen addig, amíg a felhasználó azt nem adja meg, hogy „vége”. 
            a) Egy másik tömblistába egy metódussal válogasd ki a B-vel kezdődő nevű neveket.
            b) Számold meg, hogy hány a –ra végződő nevű név van. 
            c) Döntsd el, hogy van –e a tömblistában Nagy István nevű név. Írd meg a programot az eldöntés tételével és írd meg úgy, hogy használod a tömblisták contains metódusát.
        */
        
        boolean vegegy15 = true;
        ArrayList<String> nevekgy15 = new ArrayList<>();
        String nevgy15;
        
        while(vegegy15){
            System.out.println("Kérek a következő nevet! A sor befejezéséhez írja hogy: vege.");
            nevgy15 = scan.next();
            if (nevgy15.equals("vege")) {
                vegegy15 = false;
            } else {
                nevekgy15.add(nevgy15);
            }
        }
        
        //a
        ArrayList<String> bnevekgy15 = new ArrayList<>(bNevekgy15(nevekgy15));
        for (int i = 0; i < bnevekgy15.size(); i++) {
            System.out.println(bnevekgy15.get(i));
        }
        
        //b
        int szamgy15 = 0;
        for (int i = 0; i < nevekgy15.size(); i++) {
            if (nevekgy15.get(i).endsWith("ra")) {
                szamgy15++;
            }
        }
        
        //c
        //!!
        if (nevekgy15.contains("NagyIstván")) {
            System.out.println("A tömb tartalmaz Nagy István-t");
        } else {
            System.out.println("A tömb nem tartalmaz Nagy István-t");
        }
        
        
        //Második óra: Funkcionális interfészek, lambda kifejezések
        
        ArrayList<Integer> szamok2 = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++) {
            szamok2.add(rnd.nextInt(100)+1);
        }
        System.out.println(szamok2);
        ArrayList<Integer> parosSzamok2 =  kivalogat2(szamok2, (n) -> n%2==0);
        System.out.println(parosSzamok2);
        ArrayList<Integer> paratlanSzamok2 =  kivalogat2(szamok2, (n) -> n%2==1);
        System.out.println(paratlanSzamok2);
        
        ArrayList<String> nevek2 = new ArrayList<>(Arrays.asList("Peti", "Mari", "Tibi", "Kata", "József"));
        nevek2.stream().filter(nev -> nev.endsWith("i")).forEach(nev -> System.out.println(nev));
        long db2 = nevek2.stream().filter(nev -> nev.endsWith("i")).count();
        System.out.println(db2);
        System.out.println(nevek2.stream().anyMatch(nev -> nev.startsWith("K")));
        nevek2.stream().sorted().forEach(nev -> System.out.println(nev));
        System.out.println("");
        System.out.println(nevek2.stream().min((nev1, nev2) -> nev1.compareTo(nev2)));
        
        List<String> sSzamok2 = Arrays.asList("15","2","13","17");
        List<Integer> iSzamok2 = sSzamok2.stream().map(s -> Integer.parseInt(s)).collect(Collectors.toList());
        iSzamok2.forEach(n -> System.out.println(n));
        iSzamok2.forEach(System.out::println);
        IntSummaryStatistics stat2 = iSzamok2.stream().mapToInt((x) -> x).summaryStatistics();
        System.out.println(stat2);
        System.out.println(stat2.getAverage());
        System.out.println(stat2.getMax());
        
        
        
        //Gyakorlás 2
        /*
        1) Készítsd el az eldöntés, kiválogatás, keresés, megszámolás, összeg, átlagszámítás programozási tételeket lambda kifejezések alkalmazásával.
            a) Hozz létre egy Integer értékeket tartalmazó tömblistát és töltsd fel 10 véletlenszámmal az 1 – 100 intervallumban.
            b) Készíts lambda kifejezést használó metódust, ami a megadott feltétel alapján megszámolja, hogy hány olyan elem van a tömbben, ami a feltételnek eleget tesz és ezt az értéket add vissza.
            c) Készítsd el az eldöntést lambda kifejezés használatával. Adj meg egy lambda kifejezést a metódusnak és döntse el, hogy a kifejezésnek megfelelő érték szerepel-e a tömblistában. Igaz, vagy hamis értékkel térj vissza.
            d) Készíts egy metódust, ami lambda használatával egy tömblistába kiválogatja azokat az elemeket, ami a kifejezésnek megfelelő és visszaadja ezt a tömblistát.
            e) Készíts metódusokat, ami a lambda kifejezés használatával összegzi/átlagolja azokat az elemeket, amely elemek a lambdában megfogalmazott feltételnek eleget tesznek. Az átlagoló függvény használja az összegzés függvényt!
            f) Készíts metódust, ami lambda kifejezés használatával megadja, hogy a kifejezésnek megfelelő elem melyik indexen helyezkedik el a listában.
        */
        
        //a
        ArrayList<Integer> szamokgy21 = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            szamokgy21.add(rnd.nextInt(100)+1);
        }
        
        System.out.println(szamokgy21);
        
        //b
        Long countgy21 = szamokgy21
                .stream()
                .filter(n -> n > 50)
                .count();
        
        System.out.println(countgy21);
        
        //c
        szamokgy21.add(75);
        boolean eldontesgy21 = szamokgy21
                .stream()
                .anyMatch(n -> n == 75);
        System.out.println(eldontesgy21);
        
        //d
        ArrayList<Integer> szerepelgy21 = new ArrayList<>();
        szamokgy21.stream()
                .filter(n -> n>50)
                .forEach(n -> szerepelgy21.add(n));
        System.out.println(szerepelgy21);
        
        //e
        System.out.println(szamokgy21
                .stream()
                .filter(n -> n>50)
                .mapToInt((x) -> x)
                .summaryStatistics()); //Ellenörzéshez
        
        System.out.println(szamokgy21
                .stream()
                .filter(n -> n>50)
                .mapToInt((x) -> x)
                .sum());
        
        System.out.println(szamokgy21
                .stream()
                .filter(n -> n>50)
                .mapToInt((x) -> x)
                .average());
        
        //f
        System.out.println(helymegadasgy21(szamokgy21, n -> n>50));
        
        /*
        2) A fenti feladatokat próbáld megcsinálni neveket tartalmazó listákra.
            a) Tölts fel egy tömblistát nevekkel.
            b) Számold meg, hogy hány név felel meg a lambda kifejezésben megadott feltételnek.
            c) Így tovább, készítsd el a többi programozási tételt is értelemszerűen.
        */
        
        //a
        ArrayList<String> nevekgy22 = new ArrayList<>(Arrays.asList("Peti", "Kevin", "Zsolt", "Benedek"));
        System.out.println(nevekgy22);
        
        //b
        long dbgy22 = nevekgy22
                .stream()
                .filter(n -> n.contains("i"))
                .count();
        System.out.println(dbgy22);
        
        //c
        //eldöntés
        boolean eldontesgy22 = nevekgy22
                .stream()
                .anyMatch(n -> n.contains("i"));
        System.out.println(eldontesgy22);
        
        //d
        //kiválasztás 
        ArrayList<String> szerepelgy22 = new ArrayList<>();
        nevekgy22.stream()
                .filter(n -> n.contains("i"))
                .forEach(n -> szerepelgy22.add(n));
        System.out.println(szerepelgy22);
        
        //e
        //Összeg meg átlag nem lesz Stringeknél
        
        //f !!Nem lambda
        System.out.println(helymegadasgy22(nevekgy22, "Peti"));
        
        /*
        3) Készítsd el a maximum vagy minimum értéket tömblistából kiválasztó metódust lambda függvénnyel. Csak egy metódus legyen, ami a lambda kifejezésnek megfelelően vagy a maximum, vagy a minimum értéket választja ki.
        */
        
        ArrayList<Integer> szamokgy23 = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            szamokgy23.add(rnd.nextInt(100)+1);
        }
        System.out.println(maxpermingy23(szamok2, (x, y) -> x>y));
        System.out.println(maxpermingy23(szamok2, (x, y) -> x<y));
        
        /*
        4) Készíts egy Integer értékeket tárolni képes List típusú listát. Az értékeket azonnal inicializáld, írj bele 5 értéket.
            a) Írd ki a listát a lista foreach metódusával kétféleképpen. A foreach-ben használj lambda kifejezést és a kiíró utasítást a másik megoldásban metódusreferenciát használj.
            b) Külön külön utasítással szűrd ki a listából a páros számokat, a 20 és 80 közötti számokat, a 20 és 80 közötti páros számokat és listázd őket.
            c) Konvertáld a listát string listává, ami a számokat stringként tárolja.
            d) Készítsd el a lista általános statisztikai elemzését. Írd ki a lista elemeinek számát, maximum, minimum értékét, összegét, átlagát
        */
        
        //a
        List<Integer> szamokgy24 = Arrays.asList(5, 7, 57, 75, 68);
        szamokgy24
                .forEach(n -> System.out.println(n));
        szamokgy24
                .forEach(System.out::println);
        
        //b
        ArrayList<Integer> szurogy24 = new ArrayList<>();
        szamokgy24
                .stream()
                .filter(n -> n%2==0)
                .mapToInt((x) -> x)
                .forEach(n -> szurogy24.add(n));
        System.out.println(szurogy24);
        szamokgy24
                .stream()
                .filter(n -> n>20)
                .filter(n -> 80<n)
                .mapToInt((x) -> x)
                .forEach(n -> szurogy24.add(n));
        System.out.println(szurogy24);
        szamokgy24
                .stream()
                .filter(n -> n>20)
                .filter(n -> 80<n)
                .mapToInt((x) -> x)
                .filter(n -> n%2==0)
                .forEach(n -> szurogy24.add(n));
        System.out.println(szurogy24);
        
        //c
        szamokgy24.stream().map((x) -> x);
        
        //d
        System.out.println(szamokgy24.stream().mapToInt((x)->x).summaryStatistics());
        
        //Harmadik óra: Osztályok, objektumok
        
        String rendszam31 = "AAB-889";
        Integer gyartasiEv31 = 2013;
        String gyartmany31 = "Volvo";
        
        String rendszam32 = "BBA-231";
        Integer gyartasiEv32 = 2002;
        String gyartmany32 = "Mercedes";
        
        String rendszam33 = "KKV-547";
        Integer gyartasiEv33 = 2018;
        String gyartmany33 = "Skoda";
        
        //Construcor nélkül működik így.
        /*
        Gepjarmu gj31 = new Gepjarmu();
        gj31.rendszam = "KKV-598";
        gj31.gyartasiEv = 2013;
        gj31.gyartmany = "Volvo";
        
        Gepjarmu gj32 = new Gepjarmu();
        gj32.rendszam = "ZTR-584";
        gj32.gyartasiEv = 2002;
        gj32.gyartmany = "Mercedes";
        
        Gepjarmu gj33 = new Gepjarmu();
        gj33.rendszam = "KKV-598";
        gj33.gyartasiEv = 2013;
        gj33.gyartmany = "Volvo";
        */
        
        Gepjarmu gj31 = new Gepjarmu("KKV-598", 2013, "Volvo");
        Gepjarmu gj32 = new Gepjarmu("MNB-897", 1987, "Mercedes");
        Gepjarmu gj33 = new Gepjarmu("ZTH-423", 2014, "Skoda");
        
        System.out.println(gj31);
        System.out.println(gj32);
        System.out.println(gj33);
        
        ArrayList<Gepjarmu> gepjarmuvek3 = new ArrayList<>();
        gepjarmuvek3.add(gj31);
        gepjarmuvek3.add(gj32);
        gepjarmuvek3.add(gj33);
        
        /*
        System.out.println(gepjarmuvek3);
        System.out.println(gepjarmuvek3.get(0));
        System.out.println(gepjarmuvek3.get(1).rendszam);
        System.out.println(gepjarmuvek3.get(0).gyartmany.charAt(0));
        */
        
        gepjarmuvek3.stream().filter(gj -> gj.rendszam.contains("8")).forEach(System.out::println);
        
        
        //Gyakorlás 3
        
        /*
        1.  Készíts Tanulo osztályt, amelynek adattagjai: neptunkód, név, város, életkor!
                Készíts egy tanuló típusú objektumot az osztályból!
                Add meg a tanuló adatait!
                Írd ki a tanuló adatait!
                Egészítsd ki a Tanuló osztályt egy 4 elemű tömbbel, ami a tanuló osztályzatait tartalmazza osztalyzatok néven. Add meg a tanuló osztályzatait.
        */
        
        int[] osztalyzatgy31a = {5, 5, 5, 5};
        int[] osztalyzatgy31b = {5, 5, 5, 5};
        int[] osztalyzatgy31c = {5, 5, 5, 5};
        int[] osztalyzatgy31d = {5, 5, 5, 5};
        
        Osztalygy31 tanulo1 = new Osztalygy31("ASD123", "Nagy Barna", "Szeged", 18, osztalyzatgy31a);
        Osztalygy31 tanulo2 = new Osztalygy31("YXCQWE", "Fütty Imre", "Budapest", 19, osztalyzatgy31b);
        Osztalygy31 tanulo3 = new Osztalygy31("FGH456", "Kis Tamás", "Budapest", 20, osztalyzatgy31c);
        Osztalygy31 tanulo4 = new Osztalygy31("RTZVBN", "Pál Lajos", "Szikszo", 21, osztalyzatgy31d);
        
        ArrayList<Osztalygy31> OsztalyTagjaigy31 = new ArrayList<>();
        OsztalyTagjaigy31.add(tanulo1);
        OsztalyTagjaigy31.add(tanulo2);
        OsztalyTagjaigy31.add(tanulo3);
        OsztalyTagjaigy31.add(tanulo4);
        
        System.out.println(OsztalyTagjaigy31);
        
        
        /*
        2.  Készíts egy 5 elemű tömblistát kurzusHallgatoi néven, amelynek elemei az előző feladatban definiált Tanulo típusú egyedeket tartalmazhat!
                Egy eljárásban kérd be a billentyűzetről a tanulók adatait a tömblistába!
                Egy eljárásban írd ki a tanulók adatait! Az osztálynak készítsd el a toString metódusát és azt használd a kiírásra.
                A tanulók adatait írd ki a tömblista foreach metódusával is.
                Készíts metódust, ami a tanulók tömblistájában megkeresi az adott tanulót a neptunkódja alapján. A függvény a neptunkódot paraméterül kapja.
                A tömblista stream objektumával is oldd meg az előző feladatot. A megoldáshoz használhatod a stream filter objektumát, aminek paraméteréül lambda kifejezést adsz a tanuló neptunkódjára vonatkozóan, pl. (t -> t.neptunKod.equalsIgnoreCase("GHH8JE")), majd a findFirst() metódust használhatod, ami visszaadja az Optional típusú objektumot, ami után a get() függvénnyel a tanuló objektumot kapod vissza.
                Készíts függvényt, ami kiszámítja egy tanuló átlagát. Hogy melyik tanuló átlagát számítsa ki, a tanuló neptunkódjával add meg. Használd az előző feladatban elkészített kereső függvényt a tanuló azonosítására. A main()-ben hívd meg a függvényt és írd ki az átlagot!
                Készíts függvényt, ami visszaadja a legrosszabb tanuló nevét! Legrosszabb tanuló az, akinek a legalacsonyabb az átlaga.
                Készíts függvényt, ami visszaadja a legjobb tanuló objektumát (A legjobb tanuló összes adatát tartalmazó objektumot). A legjobb tanuló az, akinek az átlaga a legmagasabb.
            A következő feladatokat a lista stream() objektumával végezd el!
                A filter használatával szűrd ki a B-vel kezdődő városban lakókat, majd listázd őket a foreach metódussal. A foreachben metódus referenciát használj.
                A filter és count függvények használatával add meg, hogy hányan laknak Budapesten.
                Határozd meg a tanulók átlagos életkorát. A megoldáshoz használd a stream mapToInt() metódusát!
                Határozd meg a legidősebb, legfiatalabb életkorokat. (mapToInt, summaryStatistics együttes használata)
                Add meg a legidősebb, legfiatalabb tanuló objektumát. Használd a stream max, min függvényét comparator használatával. pl: (stream().min((t, t1) -> Integer.compare(t.eletkor, t1.eletkor)).get())
                Határozd meg a Budapesten tanulók átlagos életkorát! (filter, mapToInt együttes használata)
                Egy új listába szűrd ki a budapesti hallgatókat, majd listázd őket.
                Egy új listában add meg a városokat. (Ismétlődés megengedett). Módosítsd az utasítást úgy, hogy a városokat névsor szerint rendezetten adja. (sorted metódus)
                Módosítsd az előző feladatban létrehozott utasítást úgy, hogy a lista csak a különböző városokat adja. Használd a map után a distinct() utasítást ami kiszűri az egyezőségeket.
                Az előző utasítás módosításával határozd meg, hogy hány különböző városban laknak a hallgatók.
        */
        
        ArrayList<kurzusHallgatoigy32> kurzusgy32 = new ArrayList<>(); //!!
        /*
        for (int i = 0; i < 5; i++) {
            System.out.println("Add meg a tanuló neptunkódját");
            String neptunkodgy32 = scan.next();
            System.out.println("Add meg a tanuló nevét");
            String nevgy32 = scan.next();
            System.out.println("Add meg a tanuló városát");
            String varosgy32 = scan.next();
            System.out.println("Add meg a tanuló életkorát");
            int eletkorgy32 = scan.nextInt();
            System.out.println("Add meg a tanuló matek jegyét");
            int matekjegygy32 = scan.nextInt();
            System.out.println("Add meg a tanuló történelem jegyét");
            int törijegygy32= scan.nextInt();
            System.out.println("Add meg a tanuló irodalom jegyét");
            int irodalomjegygy32= scan.nextInt();
            System.out.println("Add meg a tanuló hittan jegyét");
            int hittanjegygy32= scan.nextInt();
            
            
            
            
        }
        */
        
        
        
        
        
        //3. feladat!!
        
        
        
        
        
        
        
        //Negyedik óra: Fájlkezelés, kivételkezelés
        
        //CSV fájl adatainak beolvasása tömblistába
        File f = new File ("C:\\Users\\Peti\\OneDrive\\Asztali gép\\Iskola\\Prog 2\\Progr41.txt");
        System.out.println(f.exists());
        System.out.println(f.length());
        System.out.println(f.canRead());
        fileRead4(gepjarmuvek3, f);
        gepjarmuvek3.forEach(System.out::println);
        System.out.println("");
        gepjarmuvek3.stream().filter(gj -> gj.gyartasiEv > 2000).forEach(System.out::println);
        
        
        
        
        
        
    }
    
    static ArrayList<Integer> kivalogatParosok1(ArrayList<Integer> lista){ // ctrl + r --> A kijelölt metódus nevét át lehet írni és a codeban minden helyen átírja
        ArrayList<Integer> parosak = new ArrayList<>();
        for (int i = 0; i < lista.size(); i++) {
            int szam = lista.get(i);
            if (szam%2==0) {
                parosak.add(szam);
            }
        }
        return parosak;
    }
    
    static ArrayList<Integer> kivalogatParatlanok1(ArrayList<Integer> lista){ 
        ArrayList<Integer> paratlanok = new ArrayList<>();
        for (int i = 0; i < lista.size(); i++) {
            int szam = lista.get(i);
            if (szam%2==1) {
                paratlanok.add(szam);
            }
        }
        return paratlanok;
    }
    
    static ArrayList<String> bNevekgy15(ArrayList<String> lista){
        ArrayList<String> nevek = new ArrayList<>();
        lista.stream().filter(n -> n.startsWith("B")).forEach(n -> nevek.add(n));
        return nevek;
    }
    
    static ArrayList<Integer> kivalogat2(ArrayList<Integer> lista, Filter filt){ 
        ArrayList<Integer> szamok = new ArrayList<>();
        for (int i = 0; i < lista.size(); i++) {
            int szam = lista.get(i);
            if (filt.function(szam)) {
                szamok.add(szam);
            }
        }
        return szamok;
    }
    
    static int helymegadasgy21 (ArrayList<Integer> lista, Filter filt){
        for (int i = 0; i < lista.size(); i++) {
            int szam = lista.get(i);
            if (filt.function(szam)) {
                return i;
            }
            
        }
        return -1;
    }
    
    static int helymegadasgy22 (ArrayList<String> lista, String name){
        for (int i = 0; i < lista.size()-1; i++) {
            if (lista.get(i).equals(name)) {
                return i;
            }
        }
        return -1;
    }
    
    static double maxpermingy23(ArrayList<Integer> lista, Comperegy23 filt){
        int keresettErtek = lista.get(0);
        for (int i = 0; i < lista.size(); i++) {
            if (filt.function(lista.get(i), keresettErtek)) {
                keresettErtek=lista.get(i);
            }
        }
        return keresettErtek;
    }
    
    static void fileRead4(ArrayList<Gepjarmu> gepjarmuvek, File f){
        try {
            Scanner scanner = new Scanner(f, "ISO-8859-2");
            /*
            System.out.println(scanner.hasNextLine());
            System.out.println(scanner.nextLine());
            System.out.println(scanner.nextLine());
            */
            while(scanner.hasNextLine()){
                String sor = scanner.nextLine();
                String[] adatok = sor.split(";");
                //System.out.println(sor);
                //System.out.println(adatok[0]);
                Gepjarmu gj = new Gepjarmu(adatok[0],Integer.parseInt(adatok[1]),adatok[2]);
                gepjarmuvek.add(gj);
            }
            
            
            
            
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    
    
    
    
}
