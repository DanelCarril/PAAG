# PAAGBAT - NBA Datuen Kudeaketa Aplikazioa 🏀

## 💡 Helburua

Aplikazio honen helburua da NBAko taldeak, jokalariak, partidak eta estatistikak kudeatzeko sistema sinple bat eskaintzea. Erabiltzaile batek aplikazioan sartu ondoren, interfaze grafiko baten bidez datuak kontsultatu eta filtratzeko aukera dauka. Taldeen informazioa ikus daiteke, jokalariak filtratu taldeka, partidak egunez eta egoeraz (jokatuta edo ez), eta estatistikak kontsultatu jokalarien arabera.

## 🗄️ Datu-basearen egitura

Datu-basea `nba_db` izenekoa da, eta honako taulak ditu:
- **taldea**: Taldearen informazioa gordetzen du (izena, hiria, entrenatzailea, conference, estadioa).
- **jokalaria**: Jokalariaren informazioa (izena, abizena, posizioa, adina, taldea_id).
- **partida**: Partiden datuak (bertako eta kanpoko taldeak, puntuak, data, jokatuta ala ez).
- **estatistika**: Jokalari bakoitzaren puntu, errebote eta asistentzien estatistikak.
- **erabiltzaileak**: Login egiteko erabiltzaile eta pasahitzak gordetzen dira.

### 📄 SQL Script-a

Datu-basearen taulak eta hasierako datuak sortzeko SQL script bat erantsita dago fitxategi honetan:  
[`Datu basea`](nba_db.sql)

## 📊 Klase Diagrama

Proiektuaren klase diagrama hemen ikus daiteke:  
[Model base](klase_diagramak/model_base.png)  
[Model](klase_diagramak/model.png)


## ⚠️ Ahulguneak eta Hobekuntzak

- **Datuen sarrera/aldaketa ez dago erabilgarri**; erabiltzaileak ezin ditu jokalari berriak gehitu edo aldaketak egin.
- **Estatistikak ez dira grafiko edo bisualki aurkezten**.
- Etorkizunean **CRUD funtzionalitate osoa** (sortu, irakurri, eguneratu, ezabatu) aplikatu daiteke aplikazioan. Oraingoz programa bisual bat da.

---

📁 **Oharra**: Aplikazioa JavaFX erabiliz garatu da, eta `README.md` fitxategia GitHub-en ikusgarri egon dadin prestatuta dago.

#### Danel Carril Mancebo