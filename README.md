# Csomagküldő rendszer

Java nyelvű, konzolos alkalmazás csomagok feladására és állapotuk kezelésére. A projekt a **Strategy**, **State** és **Observer** tervezési minták gyakorlati használatát mutatja be.

## Futtatás

A projekt legalább Java 21-es verzióval futtatható:

```bash
java Main.java
```

## Használat

A konzolos menüben az alábbi műveletek érhetők el:

1. **Új csomag feladása:** címzett, tömeg (0-nál nagyobb, legfeljebb 30 kg) és normál vagy expressz szállítás megadása. A program kiszámítja a szállítási díjat.
2. **Csomag továbbítása:** a kiválasztott csomag átléptetése a következő állapotba.
3. **Csomag lemondása:** lemondás, ha az aktuális állapot még engedi.
4. **Csomagok listázása:** a rögzített csomagok és adataik megtekintése.
5. **Eseménynapló:** az állapotváltozások listázása időbélyeggel.
6. **Kilépés:** a `0` menüponttal.

A csomagok és a napló adatai csak a program futása alatt maradnak meg.

## Felhasznált tervezési minták

### 1. Strategy – szállítási díj számítása

A `ShippingStrategy` interfész különböző díjszámítási algoritmusokat tesz felcserélhetővé.

A `StandardShipping` és az `ExpressShipping` eltérő díjszabást valósít meg, így új szállítási mód hozzáadható a csomagkezelés módosítása nélkül futási időben.

### 2. State – csomagállapotok kezelése

A `ParcelState` interfész és az állapotosztályok (`CreatedState`, `PackedState`, `InTransitState`, `DeliveredState`, `CancelledState`) határozzák meg a lehetséges állapotátmeneteket és a lemondás feltételeit.

Az `advance(Parcel parcel)` és `cancel(Parcel parcel)` műveletek paraméterként kapják meg a csomagot. Az állapotosztályok a `parcel.setState(...)` hívással állítják be a következő állapotot. A `Parcel` a műveleteket az aktuális állapotobjektumra delegálja.

### 3. Observer – állapotváltozások követése

A `ParcelObserver` interfészen keresztül a `Parcel` értesíti a feliratkozott megfigyelőket állapotváltozáskor.

A `ConsoleNotifier` konzolos értesítést jelenít meg, az `EventLog` pedig időbélyeggel naplózza az eseményt.
