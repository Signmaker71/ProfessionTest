# ProfessionTest
### Az automata tesztek során a Profession.hu, Magyarország legkeresettebb álláskereső portáljának néhány funkcióját tesztelem.
A portál célja, hogy álláshirdetőket álláskeresőkkel kapcsoljon össze. A sikeres működtetéshez fontos, hogy az álláshirdetők és az álláskeresők részletes adatokat adjanak meg, ez segíti a backendben a megfelelő találatok párosítását.
Az adatok hibás tárolása, vagy nem megfelelő feldolgozása, hibás , azaz nem releváns találatokhoz vezet, ekkor egy álláshirdető számára valamely szempont szerint nem megfelelő jelöltet, vagy egy álláskereső számára nem a számára értékes állásajánlatot küld a rendszer.

### Az oldal, a vizsgaremek szempontjából lényeges funkciói:
- A portálon lehetőség van álláskeresőként regisztrálni, illetve a regisztráció során önéletrajzi profilt létrehozni,
  ezt később, a regisztráció során megadott felhasználónévvel és jelszóval belépve módosítani.
- ReCapcha miatt nem a Profession.hu oldalon, hanem a Professionjatekok.hu oldalon történik a regisztráció 
- A Profession.hu egy játék keretében új felhasználókat toboroz, a játék során nyereményekkel ösztönözve a felhasználót, 
  hogy minél több adattal töltse fel az önéletrajzi profilját.
- A játék elindulásakor kérdésekre kell válaszolni, a válaszok alapján az új kérdések eltérőek lehetnek.

### Tesztelés 
- A vizsgaremek szempontjából főbb feladatok már a játéknak az első szakaszán megvalósulnak, így csak 
  egy bizonyos rész-folyamaton megy végig a tesztprogram, ebben a szakaszban kerülnek be, illetve módosulnak az önélerajzi adatok, 
  ezután a Profession.hu oldalon történik a további tesztelés.
- Regisztált felhasználóként a játék során bevitt adatok az önéletrajzban meg kell hogy jelenjenek, és módosíthatók kell legyenek.
- A regisztrációhoz, a mezők kitöltéséhez, gombok lekattintásához meghatározott txt file-okból olvassa a teszprogram az adatokat,
  illetve az utoljára regisztrált e-mail címet módosítja és át is írja a program, ezzel biztosítva, hogy ugyanazzal az e-mail címmel 
  már ne próbáljon újra regisztrálni. (sajnos ez a funkció blokkolta a CI/CD futását, így ez részben módosításra került)
- Az önéletrajzban a bejelentkezett felhasználó ellenőrizheti és módosíthatja adatait.
- Az állások listájában regisztráció nélkül is lehet az állásajánlatok között keresni, a keresés során lehetőség van 
  a hirdetésben szereplő kulcsszavak alapján, és/vagy lokáció alapján szűrni. Hibás eredménynek tekinthető, 
  ha "ács" munkakör szerinti szűrésbe CNC marós álláshirdetés kerül (hiába Ács városban lett meghirdetve), 
  vagy ha "Ács" városban történő kereséskor ács munkakör kerül listázásra, hacsak nem "Ács" városban keresnek ácsot.
- A fenti hibákról hibalista készül lementett file formájában:
  - a logRecords.txt tartalmaz egy egyedi azonosítót, és a hibás hirdetés adatait.
  - az egyedi azonosítók egy külön listában is szerepelnek logIndex.txt, itt a hibajegy létrehozásának dátuma és 
    a hiba feltárásával kapcsolatos teszteset száma is megtalálható.
    

Az automata tesztek elkészítéséhez POM struktúrában dolgoztam, a teszthez szükséges, de az oldalakkal kapcsolatos funkciók 
az src/main/java mappa alatti package-ekben vannak, míg a tesztesetek az src/test/java alatti package-ekben találhatóak.
A tesztek minden Github-ra történő push alkalmával automatikusan lefutnak, az eredményről szintén automatikusan Allure jelentés készül. 

A játék során az üzemeltetés különböző funkciókat módosít, javít, így az idővel eltérő működés elkerülése érdekében a játék V2-es változatára írtam a teszteket. A Profession.hu oldalról történő kattintással a játékbaban megjelenő oldalak ettől a folyamattól a vizsga napján eltérhetnek, remélhetőleg a V2-es folyamat továbbra is elérhető marad.

### Vizsgált weboldalak:
https://www.professionjatekok.hu/v2/index
https://www.profession.hu

### A teszteseteket és a hibajegyeket az alábbi táblázat külön füleken tartalmazza:
https://docs.google.com/spreadsheets/d/1j4OSNjDw0RgM63geX_KR5iPWyX7orF3_yfqT0D0RJQk/edit?usp=sharing

### A program Java nyelven készült, a tesztek Selenium és JUnit 5 -ben készültek, a repository címe:
  https://github.com/Signmaker71/ProfessionTest/

### A használt tesztadat- és log file-ok 
kiterjesztésük txt, a repositoryban a pipeline lefutásakor nem, de lokális környezetben futtatva 
bizonyos tesztek esetén módosulnak. 

A tesztek futásakor két vizsgált folyamatnál készülnek automatikusan hibajegyek, itt a file-ban rögzített 
utolsó hibajegy azonosítóját eggyel növelve, új azonosítóval rögzítésre kerül a hiba ideje, a teszteset száma,
külön file-ban pedig az azonosító, a teszteset száma és neve, valamint az eltérő adatok, a hibás működés megismeréséhez.
- az egyedi azonosítók listája a logIndex.txt fileban szerepelnek , itt a hibajegy létrehozásának dátuma és
  a hiba feltárásával kapcsolatos teszteset száma is megtalálható.
- a logRecords.txt tartalmazza egy egyedi azonosítót, és a hibával kapcsolatos adatokat.

### A reportok a tesztek futásáról Allure framework segítségével készültek
https://signmaker71.github.io/ProfessionTest/28/#
A fenti report mutatja, hogy mind a 14 teszteset rendben lefutott, 
12 az elvárt eredménnyel, 2 pedig hibát talált az oldalon.













