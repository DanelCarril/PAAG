namespace Agenda
{
    partial class Form1
    {
        /// <summary>
        /// Variable del diseñador necesaria.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Limpiar los recursos que se estén usando.
        /// </summary>
        /// <param name="disposing">true si los recursos administrados se deben desechar; false en caso contrario.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Código generado por el Diseñador de Windows Forms

        /// <summary>
        /// Método necesario para admitir el Diseñador. No se puede modificar
        /// el contenido de este método con el editor de código.
        /// </summary>
        private void InitializeComponent()
        {
            this.components = new System.ComponentModel.Container();
            this.label1 = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.label3 = new System.Windows.Forms.Label();
            this.label4 = new System.Windows.Forms.Label();
            this.label5 = new System.Windows.Forms.Label();
            this.tbIzena = new System.Windows.Forms.TextBox();
            this.tbAbizena = new System.Windows.Forms.TextBox();
            this.tbTelefonoa = new System.Windows.Forms.TextBox();
            this.tbPrefijoa = new System.Windows.Forms.TextBox();
            this.cbGeneroa = new System.Windows.Forms.ComboBox();
            this.btnGorde = new System.Windows.Forms.Button();
            this.btnIkusi = new System.Windows.Forms.Button();
            this.btnBilatu = new System.Windows.Forms.Button();
            this.dataGridView1 = new System.Windows.Forms.DataGridView();
            this.kontaktuaBindingSource = new System.Windows.Forms.BindingSource(this.components);
            this.kontaktuaBindingSource1 = new System.Windows.Forms.BindingSource(this.components);
            this.chartGeneroa = new KontaktuaGrafikoa.Grafikoa();
            ((System.ComponentModel.ISupportInitialize)(this.dataGridView1)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.kontaktuaBindingSource)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.kontaktuaBindingSource1)).BeginInit();
            this.SuspendLayout();
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(146, 117);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(42, 16);
            this.label1.TabIndex = 0;
            this.label1.Text = "Izena:";
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(146, 150);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(59, 16);
            this.label2.TabIndex = 1;
            this.label2.Text = "Abizena:";
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(146, 185);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(69, 16);
            this.label3.TabIndex = 2;
            this.label3.Text = "Telefonoa";
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Location = new System.Drawing.Point(146, 221);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(60, 16);
            this.label4.TabIndex = 3;
            this.label4.Text = "Generoa";
            // 
            // label5
            // 
            this.label5.AutoSize = true;
            this.label5.Location = new System.Drawing.Point(146, 258);
            this.label5.Name = "label5";
            this.label5.Size = new System.Drawing.Size(53, 16);
            this.label5.TabIndex = 4;
            this.label5.Text = "Prefijoa";
            // 
            // tbIzena
            // 
            this.tbIzena.Location = new System.Drawing.Point(243, 109);
            this.tbIzena.Multiline = true;
            this.tbIzena.Name = "tbIzena";
            this.tbIzena.Size = new System.Drawing.Size(100, 24);
            this.tbIzena.TabIndex = 5;
            // 
            // tbAbizena
            // 
            this.tbAbizena.Location = new System.Drawing.Point(243, 142);
            this.tbAbizena.Multiline = true;
            this.tbAbizena.Name = "tbAbizena";
            this.tbAbizena.Size = new System.Drawing.Size(121, 24);
            this.tbAbizena.TabIndex = 6;
            // 
            // tbTelefonoa
            // 
            this.tbTelefonoa.Location = new System.Drawing.Point(243, 177);
            this.tbTelefonoa.Multiline = true;
            this.tbTelefonoa.Name = "tbTelefonoa";
            this.tbTelefonoa.Size = new System.Drawing.Size(121, 24);
            this.tbTelefonoa.TabIndex = 7;
            // 
            // tbPrefijoa
            // 
            this.tbPrefijoa.Location = new System.Drawing.Point(243, 250);
            this.tbPrefijoa.Multiline = true;
            this.tbPrefijoa.Name = "tbPrefijoa";
            this.tbPrefijoa.Size = new System.Drawing.Size(58, 24);
            this.tbPrefijoa.TabIndex = 9;
            // 
            // cbGeneroa
            // 
            this.cbGeneroa.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDownList;
            this.cbGeneroa.FormattingEnabled = true;
            this.cbGeneroa.Items.AddRange(new object[] {
            "Gizona",
            "Emakumea",
            "Bestelakoa"});
            this.cbGeneroa.Location = new System.Drawing.Point(243, 213);
            this.cbGeneroa.Name = "cbGeneroa";
            this.cbGeneroa.Size = new System.Drawing.Size(121, 24);
            this.cbGeneroa.TabIndex = 10;
            // 
            // btnGorde
            // 
            this.btnGorde.Font = new System.Drawing.Font("Microsoft Sans Serif", 9F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.btnGorde.Location = new System.Drawing.Point(167, 392);
            this.btnGorde.Name = "btnGorde";
            this.btnGorde.Size = new System.Drawing.Size(89, 31);
            this.btnGorde.TabIndex = 11;
            this.btnGorde.Text = "GORDE";
            this.btnGorde.UseVisualStyleBackColor = true;
            this.btnGorde.Click += new System.EventHandler(this.btnGorde_Click);
            // 
            // btnIkusi
            // 
            this.btnIkusi.Font = new System.Drawing.Font("Microsoft Sans Serif", 9F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.btnIkusi.Location = new System.Drawing.Point(386, 392);
            this.btnIkusi.Name = "btnIkusi";
            this.btnIkusi.Size = new System.Drawing.Size(89, 31);
            this.btnIkusi.TabIndex = 12;
            this.btnIkusi.Text = "IKUSI";
            this.btnIkusi.UseVisualStyleBackColor = true;
            this.btnIkusi.Click += new System.EventHandler(this.btnIkusi_Click);
            // 
            // btnBilatu
            // 
            this.btnBilatu.Font = new System.Drawing.Font("Microsoft Sans Serif", 9F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.btnBilatu.Location = new System.Drawing.Point(598, 393);
            this.btnBilatu.Name = "btnBilatu";
            this.btnBilatu.Size = new System.Drawing.Size(89, 31);
            this.btnBilatu.TabIndex = 13;
            this.btnBilatu.Text = "BILATU";
            this.btnBilatu.UseVisualStyleBackColor = true;
            this.btnBilatu.Click += new System.EventHandler(this.btnBilatu_Click);
            // 
            // dataGridView1
            // 
            this.dataGridView1.AllowUserToAddRows = false;
            this.dataGridView1.AllowUserToDeleteRows = false;
            this.dataGridView1.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.dataGridView1.Location = new System.Drawing.Point(96, 449);
            this.dataGridView1.Name = "dataGridView1";
            this.dataGridView1.ReadOnly = true;
            this.dataGridView1.RowHeadersWidth = 51;
            this.dataGridView1.RowTemplate.Height = 24;
            this.dataGridView1.Size = new System.Drawing.Size(664, 208);
            this.dataGridView1.TabIndex = 14;
            // 
            // kontaktuaBindingSource
            // 
            this.kontaktuaBindingSource.DataSource = typeof(KontaktuaBi.Kontaktua);
            // 
            // kontaktuaBindingSource1
            // 
            this.kontaktuaBindingSource1.DataSource = typeof(KontaktuaBi.Kontaktua);
            // 
            // chartGeneroa
            // 
            this.chartGeneroa.Location = new System.Drawing.Point(684, 12);
            this.chartGeneroa.Name = "chartGeneroa";
            this.chartGeneroa.Size = new System.Drawing.Size(659, 375);
            this.chartGeneroa.TabIndex = 15;
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(1355, 710);
            this.Controls.Add(this.chartGeneroa);
            this.Controls.Add(this.dataGridView1);
            this.Controls.Add(this.btnBilatu);
            this.Controls.Add(this.btnIkusi);
            this.Controls.Add(this.btnGorde);
            this.Controls.Add(this.cbGeneroa);
            this.Controls.Add(this.tbPrefijoa);
            this.Controls.Add(this.tbTelefonoa);
            this.Controls.Add(this.tbAbizena);
            this.Controls.Add(this.tbIzena);
            this.Controls.Add(this.label5);
            this.Controls.Add(this.label4);
            this.Controls.Add(this.label3);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.label1);
            this.Name = "Form1";
            this.Text = "Form1";
            this.Load += new System.EventHandler(this.Form1_Load);
            ((System.ComponentModel.ISupportInitialize)(this.dataGridView1)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.kontaktuaBindingSource)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.kontaktuaBindingSource1)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.Label label5;
        private System.Windows.Forms.TextBox tbIzena;
        private System.Windows.Forms.TextBox tbAbizena;
        private System.Windows.Forms.TextBox tbTelefonoa;
        private System.Windows.Forms.TextBox tbPrefijoa;
        private System.Windows.Forms.ComboBox cbGeneroa;
        private System.Windows.Forms.Button btnGorde;
        private System.Windows.Forms.Button btnIkusi;
        private System.Windows.Forms.Button btnBilatu;
        private System.Windows.Forms.DataGridView dataGridView1;
        private System.Windows.Forms.BindingSource kontaktuaBindingSource;
        private System.Windows.Forms.BindingSource kontaktuaBindingSource1;
        private KontaktuaGrafikoa.Grafikoa chartGeneroa;
    }
}

