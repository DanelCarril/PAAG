using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Drawing;
using System.Data;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using KontaktuaBi;

namespace KontaktuaGrafikoa
{
    public partial class Grafikoa : UserControl
    {
        public Grafikoa()
        {
            InitializeComponent();
        }

        public void Grafikoa_Paint(List<Kontaktua> kontaktuak)
        {
            var generoData = kontaktuak
                .GroupBy(b => b.Generoa)
                .ToDictionary(g => g.Key, g => g.Count());
            if (generoData != null && generoData.Count > 0)
            {
                chart1.Series[0].YValueMembers = "Value";
                chart1.Series[0].XValueMember = "Key";
                chart1.DataSource = generoData;
                chart1.Series[0].Label = "#PERCENT{P2}";
                chart1.DataBind();
            }
        }
    }
}
