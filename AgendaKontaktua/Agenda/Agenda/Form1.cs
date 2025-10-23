using KontaktuaBi;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Drawing.Text;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Windows.Forms.DataVisualization.Charting;
using KontaktuaGrafikoa;

namespace Agenda
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
            kontaktuak.Add(new Kontaktua("Jon", "Garcia", "600123456", "Gizona", "+34"));
            kontaktuak.Add(new Kontaktua("Maria", "Lopez", "600654321", "Emakumea", "+34"));
            kontaktuak.Add(new Kontaktua("Luis", "Matamoros", "600600600", "Bestelakoa", "+34"));
            dataGridView1.DataSource = kontaktuak;
        }

        private List<Kontaktua> kontaktuak = new List<Kontaktua>();
        private String izena, abizena, telefonoa, generoa, prefijoa;

        private void Form1_Load(object sender, EventArgs e)
        {
            chartGeneroa.Grafikoa_Paint(kontaktuak);
        }

        private void btnBilatu_Click(object sender, EventArgs e)
        {
            telefonoa = tbTelefonoa.Text;
            if (telefonoa == "")
            {
                MessageBox.Show("Telefonoa sartu behar da");
                tbTelefonoa.Focus();
                return;
            }

            foreach (Kontaktua k in kontaktuak)
            {
                if (k.Telefonoa == telefonoa)
                {
                    List<Kontaktua> bilaketa = new List<Kontaktua>();
                    bilaketa.Add(k);
                    MessageBox.Show(telefonoa + " telefonoa duen kontaktua aurkitu da!");
                    dataGridView1.DataSource = null;
                    dataGridView1.DataSource = bilaketa;
                    return;
                }
            }
            MessageBox.Show("Ez da aurkitu " + telefonoa + " telefonoa duen kontakturik!");
        }

        private void btnGorde_Click(object sender, EventArgs e)
        {
            izena = tbIzena.Text;
            abizena = tbAbizena.Text;
            telefonoa = tbTelefonoa.Text;
            generoa = cbGeneroa.Text;
            prefijoa = tbPrefijoa.Text;

            if (izena == "" || abizena == "" || telefonoa == "" || generoa == "" || prefijoa == "")
            {
                MessageBox.Show("Datu guztiak bete behar dira");
                tbIzena.Focus();
                return;
            }

            if (!Regex.IsMatch(izena, @"^[A-Za-zÀ-ÿ]+$") || !Regex.IsMatch(abizena, @"^[A-Za-zÀ-ÿ]+$"))
            {
                MessageBox.Show("Izena edo Abizena ez da zuzena");
                tbIzena.Focus();
                return;
            }

            if (telefonoa.Length != 9 || !int.TryParse(telefonoa, out _))
            {
                MessageBox.Show("Telefonoa ez da egokia");
                tbTelefonoa.Focus();
                return;
            }

            if (!Regex.IsMatch(prefijoa, @"^\+\d{2,3}$"))
            {
                MessageBox.Show("Prefijoa ez da zuzena");
                tbPrefijoa.Focus();
                return;
            }

            Kontaktua kontaktua = new Kontaktua(izena, abizena, telefonoa, generoa, prefijoa);

            kontaktuak.Add(kontaktua);
            MessageBox.Show("Kontaktua ondo gorde da!");
            tbIzena.Clear();
            tbAbizena.Clear();
            tbTelefonoa.Clear();
            tbPrefijoa.Clear();
            cbGeneroa.SelectedIndex = -1;
        }

        private void btnIkusi_Click(object sender, EventArgs e)
        {
            dataGridView1.DataSource = null;
            dataGridView1.DataSource = kontaktuak;
            chartGeneroa.Grafikoa_Paint(kontaktuak);
        }
    }
}
