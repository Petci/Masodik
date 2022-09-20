package masodik;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.IntSummaryStatistics; //??
import java.util.List; //??
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors; //??

interface Filter{
    boolean function(int n);
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
            a) Egy másik tömblistába egy metódussal válogasd ki a B-vel kezdődő nevű neveket. !!
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
        
        int szamgy15 = 0;
        for (int i = 0; i < nevekgy15.size(); i++) {
            if (nevekgy15.get(i).endsWith("ra")) {
                szamgy15++;
            }
        }
        
        if (nevekgy15.contains("NagyIstvan")) {
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
        
        //f !!
        //kifejezésnek megfelelő elem melyik indexen helyezkedik el
        ArrayList<Integer> megfelelogy21 = new ArrayList<>(szamokgy21.stream().filter(n -> n>50).collect(Collectors.toList()));
        System.out.println(megfelelogy21);
        megfelelogy21.forEach(n -> szamokgy21.contains(n));
        
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
        System.out.println(szerepelgy21);
        
        //e
        //Összeg meg átlag nem lesz Stringeknél
        
        //f !!
        
        /*
        3) Készítsd el a maximum vagy minimum értéket tömblistából kiválasztó metódust lambda függvénnyel. Csak egy metódus legyen, ami a lambda kifejezésnek megfelelően vagy a maximum, vagy a minimum értéket választja ki.
        */
        
        ArrayList<Integer> szamokgy23 = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            szamokgy23.add(rnd.nextInt(100)+1);
        }
        System.out.println(maxpermingy23(szamokgy23, (n) -> n>0)); //!!
        
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
        
        ArrayList<Gepjarmu> gepjarmuvek = new ArrayList<>();
        gepjarmuvek.add(gj31);
        gepjarmuvek.add(gj32);
        gepjarmuvek.add(gj33);
        
        System.out.println(gepjarmuvek);
        //5. perc !!
        
        
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
    
    static double maxpermingy23 (ArrayList<Integer> lista, Filter filt){
        int a = lista.get(0);
        for (int i = 1; i < lista.size(); i++) {
            if (lista.get(i) > a) {
                a=lista.get(i);
            }
        }
        return a;
    }
    
    
}
