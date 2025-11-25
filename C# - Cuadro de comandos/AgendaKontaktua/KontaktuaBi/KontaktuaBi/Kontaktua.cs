using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace KontaktuaBi
{
    public class Kontaktua
    {

        public string Izena { get; set; } = "Danel";
        public string Abizena { get; set; } = "Carril";
        public string Telefonoa { get; set; } = "666666666";
        public string Generoa { get; set; } = "Gizona";
        public string Prefijoa { get; set; }


        public Kontaktua(string izena, string abizena, string telefonoa, string generoa, string prefijoa)
        {
            Izena = izena;
            Abizena = abizena;
            Telefonoa = telefonoa;
            Generoa = generoa;
            Prefijoa = prefijoa;
        }
    }
}
