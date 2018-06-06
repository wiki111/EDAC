package graphic_interface;

import algorithms.*;
import generators.*;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Panel extends javax.swing.JFrame {

    public Panel() {

        this.signalGenerator = new Simple7BitSignalGenerator();
        this.disruptionGenerator = new BitDisruptionGenerator();

        initComponents();
        initListeners();
        addMethodGroupButtons();
    }

    private void addMethodGroupButtons(){
        GrupaMetody.add(Parzystosci);
        GrupaMetody.add(Hamminga);
        GrupaMetody.add(SDLCReverse);
        GrupaMetody.add(Crc16);
        GrupaMetody.add(Sdlc);
        GrupaMetody.add(Crc32);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        GrupaMetody = new javax.swing.ButtonGroup();
        MetodaDetekcjiKorekcji = new javax.swing.JPanel();
        Detekcji = new javax.swing.JLabel();
        Parzystosci = new javax.swing.JRadioButton();
        Hamminga = new javax.swing.JRadioButton();
        SDLCReverse = new javax.swing.JRadioButton();
        Crc16 = new javax.swing.JRadioButton();
        Sdlc = new javax.swing.JRadioButton();
        Crc32 = new javax.swing.JRadioButton();
        NadawaneBity = new javax.swing.JPanel();
        BityNadawane = new javax.swing.JLabel();
        BityNad = new javax.swing.JLabel();
        Bity = new javax.swing.JTextField();
        Generuj = new javax.swing.JButton();
        Koduj = new javax.swing.JButton();
        IloscGenerowanychBitow = new javax.swing.JSpinner();
        BityZakodowan = new javax.swing.JLabel();
        ZakodowaneNadawane = new javax.swing.JTextField();
        OdbieraneBity = new javax.swing.JPanel();
        BityOdbierane = new javax.swing.JLabel();
        ZakloconeLabel = new javax.swing.JLabel();
        Zaklocone = new javax.swing.JTextField();
        IloscZaklocanychBitow = new javax.swing.JSpinner();
        Zakloc = new javax.swing.JButton();
        Dekoduj = new javax.swing.JButton();
        OdkodowaneSuroweLabel = new javax.swing.JLabel();
        OdkodowaneKorekcjaLabel = new javax.swing.JLabel();
        OdkodowaneSurowe = new javax.swing.JTextField();
        OdkodowaneKorekcja = new javax.swing.JTextField();
        Ostatnie = new javax.swing.JPanel();
        Podsumowanie = new javax.swing.JLabel();
        PrzeslaneBityDanych = new javax.swing.JLabel();
        BledyWykryte = new javax.swing.JLabel();
        PrzeslaneBityNadmiarowe = new javax.swing.JLabel();
        BledySkorygowane = new javax.swing.JLabel();
        BledyNiewykryte = new javax.swing.JLabel();
        Wyczysc = new javax.swing.JButton();
        PrzeslaneBity = new javax.swing.JTextField();
        WykryteBledy = new javax.swing.JTextField();
        BityNadmiarowe = new javax.swing.JTextField();
        SkorygowaneBledy = new javax.swing.JTextField();
        NiewykryteBledy = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(700, 550));
        setResizable(false);

        MetodaDetekcjiKorekcji.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        MetodaDetekcjiKorekcji.setPreferredSize(new java.awt.Dimension(700, 70));

        Detekcji.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Detekcji.setText("Metoda Detekcji/Korekcji");

        Parzystosci.setText("Bit parzystości");
        Parzystosci.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ParzystosciActionPerformed(evt);
            }
        });

        Hamminga.setText("Kodowanie Hamminga");
        Hamminga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HammingaActionPerformed(evt);
            }
        });

        SDLCReverse.setText("SDLC Reverse");

        Crc16.setText("CRC16");

        Sdlc.setText("SDLC");

        Crc32.setText("CRC32");

        javax.swing.GroupLayout MetodaDetekcjiKorekcjiLayout = new javax.swing.GroupLayout(MetodaDetekcjiKorekcji);
        MetodaDetekcjiKorekcji.setLayout(MetodaDetekcjiKorekcjiLayout);
        MetodaDetekcjiKorekcjiLayout.setHorizontalGroup(
            MetodaDetekcjiKorekcjiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MetodaDetekcjiKorekcjiLayout.createSequentialGroup()
                .addComponent(Detekcji)
                .addContainerGap(521, Short.MAX_VALUE))
            .addGroup(MetodaDetekcjiKorekcjiLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(Parzystosci)
                .addGap(18, 18, 18)
                .addComponent(Hamminga)
                .addGap(18, 18, 18)
                .addComponent(Crc16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Crc32)
                .addGap(35, 35, 35)
                .addComponent(Sdlc)
                .addGap(30, 30, 30)
                .addComponent(SDLCReverse)
                .addGap(53, 53, 53))
        );
        MetodaDetekcjiKorekcjiLayout.setVerticalGroup(
            MetodaDetekcjiKorekcjiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MetodaDetekcjiKorekcjiLayout.createSequentialGroup()
                .addComponent(Detekcji)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(MetodaDetekcjiKorekcjiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SDLCReverse)
                    .addComponent(Parzystosci)
                    .addComponent(Hamminga)
                    .addComponent(Crc16)
                    .addComponent(Crc32)
                    .addComponent(Sdlc))
                .addContainerGap())
        );

        NadawaneBity.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        NadawaneBity.setPreferredSize(new java.awt.Dimension(700, 200));

        BityNadawane.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        BityNadawane.setText("Bity Nadawane");

        BityNad.setText("Bity");

        Bity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BityActionPerformed(evt);
            }
        });

        Generuj.setText("GENERUJ");
        Generuj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GenerujActionPerformed(evt);
            }
        });

        Koduj.setText("KODUJ");

        IloscGenerowanychBitow.setName(""); // NOI18N
        IloscGenerowanychBitow.setPreferredSize(new java.awt.Dimension(50, 30));
        IloscGenerowanychBitow.setValue(16);

        BityZakodowan.setText("Zakodowane");

        javax.swing.GroupLayout NadawaneBityLayout = new javax.swing.GroupLayout(NadawaneBity);
        NadawaneBity.setLayout(NadawaneBityLayout);
        NadawaneBityLayout.setHorizontalGroup(
            NadawaneBityLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NadawaneBityLayout.createSequentialGroup()
                .addGroup(NadawaneBityLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BityNadawane)
                    .addGroup(NadawaneBityLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(NadawaneBityLayout.createSequentialGroup()
                            .addComponent(IloscGenerowanychBitow, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(43, 43, 43)
                            .addComponent(Generuj)
                            .addGap(26, 26, 26)
                            .addComponent(Koduj))
                        .addGroup(NadawaneBityLayout.createSequentialGroup()
                            .addGroup(NadawaneBityLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(NadawaneBityLayout.createSequentialGroup()
                                    .addGap(14, 14, 14)
                                    .addComponent(BityZakodowan))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, NadawaneBityLayout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(BityNad)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(NadawaneBityLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(Bity, javax.swing.GroupLayout.DEFAULT_SIZE, 572, Short.MAX_VALUE)
                                .addComponent(ZakodowaneNadawane)))))
                .addGap(0, 25, Short.MAX_VALUE))
        );
        NadawaneBityLayout.setVerticalGroup(
            NadawaneBityLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NadawaneBityLayout.createSequentialGroup()
                .addComponent(BityNadawane)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(NadawaneBityLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BityNad)
                    .addComponent(Bity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(NadawaneBityLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(IloscGenerowanychBitow, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Generuj)
                    .addComponent(Koduj))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(NadawaneBityLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ZakodowaneNadawane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BityZakodowan))
                .addGap(28, 28, 28))
        );

        OdbieraneBity.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        OdbieraneBity.setPreferredSize(new java.awt.Dimension(700, 300));

        BityOdbierane.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        BityOdbierane.setText("Bity Odbierane");

        ZakloconeLabel.setText("Zakłócone");

        Zaklocone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ZakodowaneOdbieraneActionPerformed(evt);
            }
        });

        IloscZaklocanychBitow.setPreferredSize(new java.awt.Dimension(50, 30));

        Zakloc.setLabel("ZAKŁÓĆ");

        Dekoduj.setLabel("DEKODUJ");

        OdkodowaneSuroweLabel.setText("Odkodowane - surowe");

        OdkodowaneKorekcjaLabel.setText("Odkodowane - po korekcji");

        javax.swing.GroupLayout OdbieraneBityLayout = new javax.swing.GroupLayout(OdbieraneBity);
        OdbieraneBity.setLayout(OdbieraneBityLayout);
        OdbieraneBityLayout.setHorizontalGroup(
            OdbieraneBityLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(OdbieraneBityLayout.createSequentialGroup()
                .addComponent(BityOdbierane)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, OdbieraneBityLayout.createSequentialGroup()
                .addGroup(OdbieraneBityLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, OdbieraneBityLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(OdbieraneBityLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(OdbieraneBityLayout.createSequentialGroup()
                                .addComponent(OdkodowaneKorekcjaLabel)
                                .addGap(29, 29, 29)
                                .addComponent(OdkodowaneKorekcja))
                            .addGroup(OdbieraneBityLayout.createSequentialGroup()
                                .addComponent(ZakloconeLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Zaklocone, javax.swing.GroupLayout.PREFERRED_SIZE, 569, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(OdbieraneBityLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(OdbieraneBityLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, OdbieraneBityLayout.createSequentialGroup()
                                .addComponent(IloscZaklocanychBitow, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)
                                .addComponent(Zakloc)
                                .addGap(18, 18, 18)
                                .addComponent(Dekoduj))
                            .addGroup(OdbieraneBityLayout.createSequentialGroup()
                                .addComponent(OdkodowaneSuroweLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(OdkodowaneSurowe, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(26, 26, 26))
        );
        OdbieraneBityLayout.setVerticalGroup(
            OdbieraneBityLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(OdbieraneBityLayout.createSequentialGroup()
                .addComponent(BityOdbierane, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(OdbieraneBityLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ZakloconeLabel)
                    .addComponent(Zaklocone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(OdbieraneBityLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(IloscZaklocanychBitow, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Zakloc)
                    .addComponent(Dekoduj))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(OdbieraneBityLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(OdkodowaneSurowe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(OdkodowaneSuroweLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(OdbieraneBityLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(OdkodowaneKorekcjaLabel)
                    .addComponent(OdkodowaneKorekcja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        Ostatnie.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Ostatnie.setPreferredSize(new java.awt.Dimension(700, 150));

        Podsumowanie.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Podsumowanie.setText("Podsumowanie");

        PrzeslaneBityDanych.setText("Przesłane bity danych");

        BledyWykryte.setText("Błędy wykryte");

        PrzeslaneBityNadmiarowe.setText("Przesłane bity nadmiarowe");

        BledySkorygowane.setText("Błędy skorygowane");

        BledyNiewykryte.setText("Błędy niewykryte");

        Wyczysc.setText("WYCZYŚĆ");
        Wyczysc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                WyczyscActionPerformed(evt);
            }
        });

        PrzeslaneBity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PrzeslaneBityActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout OstatnieLayout = new javax.swing.GroupLayout(Ostatnie);
        Ostatnie.setLayout(OstatnieLayout);
        OstatnieLayout.setHorizontalGroup(
            OstatnieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(OstatnieLayout.createSequentialGroup()
                .addComponent(Podsumowanie)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(OstatnieLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(OstatnieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BledyWykryte)
                    .addComponent(PrzeslaneBityDanych)
                    .addComponent(PrzeslaneBityNadmiarowe))
                .addGap(13, 13, 13)
                .addGroup(OstatnieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(PrzeslaneBity, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                    .addComponent(WykryteBledy)
                    .addComponent(BityNadmiarowe))
                .addGap(18, 18, 18)
                .addGroup(OstatnieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(OstatnieLayout.createSequentialGroup()
                        .addGroup(OstatnieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(BledySkorygowane)
                            .addComponent(BledyNiewykryte))
                        .addGap(18, 18, 18)
                        .addGroup(OstatnieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(SkorygowaneBledy, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                            .addComponent(NiewykryteBledy))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, OstatnieLayout.createSequentialGroup()
                        .addGap(0, 287, Short.MAX_VALUE)
                        .addComponent(Wyczysc)
                        .addGap(57, 57, 57))))
        );
        OstatnieLayout.setVerticalGroup(
            OstatnieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(OstatnieLayout.createSequentialGroup()
                .addComponent(Podsumowanie)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(OstatnieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PrzeslaneBityDanych)
                    .addComponent(PrzeslaneBity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BledySkorygowane)
                    .addComponent(SkorygowaneBledy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(OstatnieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BledyWykryte)
                    .addComponent(WykryteBledy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BledyNiewykryte)
                    .addComponent(NiewykryteBledy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(OstatnieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PrzeslaneBityNadmiarowe)
                    .addComponent(BityNadmiarowe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Wyczysc))
                .addGap(0, 30, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(MetodaDetekcjiKorekcji, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 680, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NadawaneBity, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 680, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(OdbieraneBity, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 680, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Ostatnie, javax.swing.GroupLayout.PREFERRED_SIZE, 680, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(MetodaDetekcjiKorekcji, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(NadawaneBity, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(OdbieraneBity, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Ostatnie, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ParzystosciActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ParzystosciActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ParzystosciActionPerformed

    private void HammingaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HammingaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_HammingaActionPerformed

    private void BityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BityActionPerformed

    private void GenerujActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GenerujActionPerformed
        /*int n=Integer.parseInt(IloscGenerowanychBitow.getValue().toString());
	if (n%8!=0)
	{
            n+=8-n%8;
            IloscGenerowanychBitow.setValue(n);
	}
        DataBits inputBits = new DataBits();
	inputBits.generate(n);
	Bity.setText(inputBits.toString());*/
        int length = Integer.parseInt(IloscGenerowanychBitow.getValue().toString());

        this.signalGenerator.setSignalLength(length);

        signalGenerator.generateSignal();

        byte[] generated = signalGenerator.getGeneratedSignal();

        Bity.setText(bytesToString(generated));

    }//GEN-LAST:event_GenerujActionPerformed

    private String bytesToString(byte[] bytes){
        String generatedBits = "";

        for(byte b : bytes){
            generatedBits += Integer.toBinaryString(b & 255 | 256).substring(1) + " ";
        }

        return generatedBits;
    }

    private void ZakodowaneOdbieraneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ZakodowaneOdbieraneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ZakodowaneOdbieraneActionPerformed

    private void PrzeslaneBityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PrzeslaneBityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PrzeslaneBityActionPerformed

    private void WyczyscActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_WyczyscActionPerformed
        Bity.setText("");
	ZakodowaneNadawane.setText("");
	NiewykryteBledy.setText("");
	Zaklocone.setText("");
        OdkodowaneSurowe.setText("");
	OdkodowaneKorekcja.setText("");
	PrzeslaneBity.setText("");
	WykryteBledy.setText("");
	BityNadmiarowe.setText("");
	SkorygowaneBledy.setText("");

	this.encodedBits = null;
	this.decodedBits = null;
	this.disruptedBits = null;
	this.disruptionGenerator = new BitDisruptionGenerator();
	this.signalGenerator = new Simple7BitSignalGenerator();
    }//GEN-LAST:event_WyczyscActionPerformed

    private void initListeners(){
        initMethodButtonsListeners();
        initActionButtonsListeners();
    }

    private void initMethodButtonsListeners(){
        Crc16.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                crc16Setup();
            }
        });

        Sdlc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sdlcSetup();
            }
        });

        SDLCReverse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sdlcReverseSetup();
            }
        });

        Crc32.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                crc32Setup();
            }
        });

        Parzystosci.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                paritySetup();
            }
        });

        Hamminga.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hammingSetup();
            }
        });
    }

    private void initActionButtonsListeners(){
        Koduj.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                encode();
            }
        });

        Zakloc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                disrupt();
            }
        });

        Dekoduj.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                decode();
            }
        });
    }

    private void encode(){
        this.encodedBits = this.algorithm.encode(this.signalGenerator.getGeneratedSignal());
        String encodedDataString = bytesToString(this.encodedBits);

        ZakodowaneNadawane.setText(encodedDataString);
    }

    private void disrupt(){

        disruptionGenerator.setNumberOfBitsToDisrupt(Integer.parseInt(IloscZaklocanychBitow.getValue().toString()));

        this.disruptedBits = disruptionGenerator.disrupt(this.encodedBits);

        Zaklocone.setText(bytesToString(this.disruptedBits));
    }

    private void decode(){

        if(disruptedBits != null){
            this.decodedBits = this.algorithm.decode(this.disruptedBits);
        }else{
            this.decodedBits = this.algorithm.decode(encodedBits);
        }

        if(decodedBits != null && decodedBits.length != 0){

                OdkodowaneKorekcja.setText(bytesToString(this.decodedBits));

        }else{
            OdkodowaneKorekcja.setText(algorithm.getErrors());
        }




        PrzeslaneBity.setText(String.valueOf(countBits(encodedBits)));
        WykryteBledy.setText(String.valueOf(algorithm.getErrorsCount()));
        NiewykryteBledy.setText(String.valueOf(disruptionGenerator.getNumberOfCreatedErrors() - algorithm.getErrorsCount()));
        BityNadmiarowe.setText(String.valueOf(getNumberOfRedundantBits()));
        SkorygowaneBledy.setText(String.valueOf(algorithm.getCorrectedErrorsCount()));

    }

    private int countBits(byte[] bytes){
        return bytes.length * 8;
    }

    private int getNumberOfRedundantBits(){
        return countBits(encodedBits) - countBits(signalGenerator.getGeneratedSignal());
    }

    private void crc16Setup(){
        this.algorithm = new CyclicRedundancyCheck16Bit("crc16");
    }

    private void sdlcSetup(){
        this.algorithm = new CyclicRedundancyCheck16Bit("sdlc");
    }

    private void sdlcReverseSetup(){
        this.algorithm = new CyclicRedundancyCheck16Bit("sdlc reverse");
    }

    private void crc32Setup(){
        this.algorithm = new CyclicRedundancyCheck32Bit("crc32");
    }

    private void paritySetup(){
        this.algorithm = new EvenParityBitControl();
    }

    private void hammingSetup(){
        this.algorithm = new HammingCode();
    }

    private EDACAlgorithm algorithm;
    private SignalGenerator signalGenerator;
    private BitDisruptionGenerator disruptionGenerator;
    private byte[] encodedBits;
    private byte[] disruptedBits;
    private byte[] decodedBits;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Bity;
    private javax.swing.JLabel BityNad;
    private javax.swing.JLabel BityNadawane;
    private javax.swing.JTextField BityNadmiarowe;
    private javax.swing.JLabel BityOdbierane;
    private javax.swing.JLabel BityZakodowan;
    private javax.swing.JLabel BledyNiewykryte;
    private javax.swing.JLabel BledySkorygowane;
    private javax.swing.JLabel BledyWykryte;
    private javax.swing.JRadioButton Crc16;
    private javax.swing.JRadioButton Crc32;
    private javax.swing.JButton Dekoduj;
    private javax.swing.JLabel Detekcji;
    private javax.swing.JButton Generuj;
    private javax.swing.ButtonGroup GrupaMetody;
    private javax.swing.JRadioButton Hamminga;
    private javax.swing.JSpinner IloscGenerowanychBitow;
    private javax.swing.JSpinner IloscZaklocanychBitow;
    private javax.swing.JButton Koduj;
    private javax.swing.JPanel MetodaDetekcjiKorekcji;
    private javax.swing.JPanel NadawaneBity;
    private javax.swing.JTextField NiewykryteBledy;
    private javax.swing.JPanel OdbieraneBity;
    private javax.swing.JLabel ZakloconeLabel;
    private javax.swing.JPanel Ostatnie;
    private javax.swing.JRadioButton Parzystosci;
    private javax.swing.JTextField OdkodowaneSurowe;
    private javax.swing.JLabel OdkodowaneSuroweLabel;
    private javax.swing.JLabel Podsumowanie;
    private javax.swing.JTextField PrzeslaneBity;
    private javax.swing.JLabel PrzeslaneBityDanych;
    private javax.swing.JLabel PrzeslaneBityNadmiarowe;
    private javax.swing.JRadioButton SDLCReverse;
    private javax.swing.JRadioButton Sdlc;
    private javax.swing.JTextField SkorygowaneBledy;
    private javax.swing.JTextField OdkodowaneKorekcja;
    private javax.swing.JLabel OdkodowaneKorekcjaLabel;
    private javax.swing.JButton Wyczysc;
    private javax.swing.JTextField WykryteBledy;
    private javax.swing.JButton Zakloc;
    private javax.swing.JTextField ZakodowaneNadawane;
    private javax.swing.JTextField Zaklocone;
    // End of variables declaration//GEN-END:variables
}
