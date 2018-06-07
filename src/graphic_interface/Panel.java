package graphic_interface;

import simulation.GuiSimulationRunner;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Panel extends javax.swing.JFrame {

    // Variables declaration - do not modify//GEN-BEGIN:variables
    //Panel wyboru rodzaju detekcji/korekcji
    private javax.swing.JPanel MetodaDetekcjiKorekcjiPanel;
    private javax.swing.JLabel DetekcjaLabel;
    private javax.swing.ButtonGroup MetodyButtonGroup;
    private javax.swing.JRadioButton Crc16Radio;
    private javax.swing.JRadioButton Crc32Radio;
    private javax.swing.JRadioButton HammingRadio;
    private javax.swing.JRadioButton ParzystosciRadio;
    private javax.swing.JRadioButton SdlcReverseRadio;
    private javax.swing.JRadioButton SdlcRadio;
    //Panel nadawania - kodowanie i generacja sygnału wejściowego
    private javax.swing.JPanel NadawaneBityPanel;
    private javax.swing.JLabel BityNadawanePanelLabel;
    private javax.swing.JLabel BityNadawaneTextFieldLabel;
    private javax.swing.JTextField BityTextField;
    private javax.swing.JSpinner IloscGenerowanychBitowSpinner;
    private javax.swing.JButton GenerujButton;
    private javax.swing.JButton KodujButton;
    private javax.swing.JLabel ZakodowaneLabel;
    private javax.swing.JTextField ZakodowaneTextField;
    //Panel odbierania / zakłócania
    private javax.swing.JPanel BityOdbieranePanel;
    private javax.swing.JLabel BityOdbieraneLabel;
    private javax.swing.JLabel ZakloconeLabel;
    private javax.swing.JTextField ZakloconeTextField;
    private javax.swing.JSpinner IloscZaklocanychBitowSpinner;
    private javax.swing.JButton ZaklocButton;
    private javax.swing.JButton DekodujButton;
    private javax.swing.JLabel OdkodowaneLabel;
    private javax.swing.JTextField OdkodowaneTextField;
    //Panel podsumowanie
    private javax.swing.JPanel PodsumowaniePanel;
    private javax.swing.JLabel PodsumowanieLabel;
    private javax.swing.JLabel PrzeslaneBityDanychLabel;
    private javax.swing.JTextField PrzeslaneBityTextField;
    private javax.swing.JLabel PrzeslaneBityNadmiaroweLabel;
    private javax.swing.JLabel BledyWykryteLabel;
    private javax.swing.JTextField WykryteBledyTextField;
    private javax.swing.JTextField BityNadmiaroweTextField;
    private javax.swing.JLabel BledySkorygowaneLabel;
    private javax.swing.JTextField SkorygowaneBledyTextField;
    private javax.swing.JLabel BledyNiewykryteLabel;
    private javax.swing.JTextField NiewykryteBledyTextField;
    private javax.swing.JButton WyczyscButton;
    // End of variables declaration//GEN-END:variables

    private GuiSimulationRunner simulationRunner;

    public Panel() {
        initComponents();
        addMethodGroupButtons();
        this.simulationRunner = new GuiSimulationRunner();
        simulationRunner.setAlgorithm("hamming");
    }

    private void addMethodGroupButtons(){
        MetodyButtonGroup.add(ParzystosciRadio);
        MetodyButtonGroup.add(HammingRadio);
        MetodyButtonGroup.add(SdlcReverseRadio);
        MetodyButtonGroup.add(Crc16Radio);
        MetodyButtonGroup.add(SdlcRadio);
        MetodyButtonGroup.add(Crc32Radio);
    }

    private void initComponents() {

        initObjects();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(900, 550));
        setResizable(false);

        initMetodaPanel();
        initNadawanePanel();
        initOdbieranePanel();
        initPodsumowaniePanel();
        initLayout();

        pack();
    }

    private void initObjects(){
        MetodyButtonGroup = new javax.swing.ButtonGroup();
        MetodaDetekcjiKorekcjiPanel = new javax.swing.JPanel();
        DetekcjaLabel = new javax.swing.JLabel();
        ParzystosciRadio = new javax.swing.JRadioButton();
        HammingRadio = new javax.swing.JRadioButton();
        SdlcReverseRadio = new javax.swing.JRadioButton();
        Crc16Radio = new javax.swing.JRadioButton();
        SdlcRadio = new javax.swing.JRadioButton();
        Crc32Radio = new javax.swing.JRadioButton();
        NadawaneBityPanel = new javax.swing.JPanel();
        BityNadawanePanelLabel = new javax.swing.JLabel();
        BityNadawaneTextFieldLabel = new javax.swing.JLabel();
        BityTextField = new javax.swing.JTextField();
        GenerujButton = new javax.swing.JButton();
        KodujButton = new javax.swing.JButton();
        IloscGenerowanychBitowSpinner = new javax.swing.JSpinner();
        ZakodowaneLabel = new javax.swing.JLabel();
        ZakodowaneTextField = new javax.swing.JTextField();
        BityOdbieranePanel = new javax.swing.JPanel();
        BityOdbieraneLabel = new javax.swing.JLabel();
        ZakloconeLabel = new javax.swing.JLabel();
        ZakloconeTextField = new javax.swing.JTextField();
        IloscZaklocanychBitowSpinner = new javax.swing.JSpinner();
        ZaklocButton = new javax.swing.JButton();
        DekodujButton = new javax.swing.JButton();
        OdkodowaneLabel = new javax.swing.JLabel();
        OdkodowaneTextField = new javax.swing.JTextField();
        PodsumowaniePanel = new javax.swing.JPanel();
        PodsumowanieLabel = new javax.swing.JLabel();
        PrzeslaneBityDanychLabel = new javax.swing.JLabel();
        BledyWykryteLabel = new javax.swing.JLabel();
        PrzeslaneBityNadmiaroweLabel = new javax.swing.JLabel();
        BledySkorygowaneLabel = new javax.swing.JLabel();
        BledyNiewykryteLabel = new javax.swing.JLabel();
        WyczyscButton = new javax.swing.JButton();
        PrzeslaneBityTextField = new javax.swing.JTextField();
        WykryteBledyTextField = new javax.swing.JTextField();
        BityNadmiaroweTextField = new javax.swing.JTextField();
        SkorygowaneBledyTextField = new javax.swing.JTextField();
        NiewykryteBledyTextField = new javax.swing.JTextField();
    }

    private void initMetodaPanel() {
        MetodaDetekcjiKorekcjiPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        MetodaDetekcjiKorekcjiPanel.setPreferredSize(new java.awt.Dimension(900, 70));

        DetekcjaLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        DetekcjaLabel.setText("Metoda DetekcjaLabel/Korekcji");

        SdlcReverseRadio.setText("SDLC Reverse");
        Crc16Radio.setText("CRC16");
        SdlcRadio.setText("SDLC");
        Crc32Radio.setText("CRC32");
        HammingRadio.setText("Kodowanie Hamminga");
        ParzystosciRadio.setText("Kontrola Parzystości");

        HammingRadio.setSelected(true);

        initMetodaRadioListeners();

        javax.swing.GroupLayout MetodaDetekcjiKorekcjiLayout = new javax.swing.GroupLayout(MetodaDetekcjiKorekcjiPanel);
        MetodaDetekcjiKorekcjiPanel.setLayout(MetodaDetekcjiKorekcjiLayout);
        MetodaDetekcjiKorekcjiLayout.setHorizontalGroup(
                MetodaDetekcjiKorekcjiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                        .addGroup(MetodaDetekcjiKorekcjiLayout.createSequentialGroup()
                                .addComponent(DetekcjaLabel)
                                .addContainerGap(521, Short.MAX_VALUE))
                        .addGroup(MetodaDetekcjiKorekcjiLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(ParzystosciRadio)
                                .addGap(18, 18, 18)
                                .addComponent(HammingRadio)
                                .addGap(18, 18, 18)
                                .addComponent(Crc16Radio)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Crc32Radio)
                                .addGap(35, 35, 35)
                                .addComponent(SdlcRadio)
                                .addGap(30, 30, 30)
                                .addComponent(SdlcReverseRadio)
                                .addGap(53, 53, 53))
        );
        MetodaDetekcjiKorekcjiLayout.setVerticalGroup(
                MetodaDetekcjiKorekcjiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                        .addGroup(javax.swing.GroupLayout.Alignment.CENTER, MetodaDetekcjiKorekcjiLayout.createSequentialGroup()
                                .addComponent(DetekcjaLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(MetodaDetekcjiKorekcjiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(SdlcReverseRadio)
                                        .addComponent(ParzystosciRadio)
                                        .addComponent(HammingRadio)
                                        .addComponent(Crc16Radio)
                                        .addComponent(Crc32Radio)
                                        .addComponent(SdlcRadio))
                                .addContainerGap())
        );
    }

    private void initMetodaRadioListeners() {

        SdlcRadio.addActionListener(e -> simulationRunner.setAlgorithm("sdlc"));

        SdlcReverseRadio.addActionListener(e -> simulationRunner.setAlgorithm("sdlc reverse"));

        Crc16Radio.addActionListener(e -> simulationRunner.setAlgorithm("crc16"));

        Crc32Radio.addActionListener(e -> simulationRunner.setAlgorithm("crc32"));

        ParzystosciRadio.addActionListener(e -> simulationRunner.setAlgorithm("parity"));

        HammingRadio.addActionListener(e -> simulationRunner.setAlgorithm("hamming"));

    }

    private void initNadawanePanel() {
        NadawaneBityPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        NadawaneBityPanel.setPreferredSize(new java.awt.Dimension(900, 200));

        BityNadawanePanelLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        BityNadawanePanelLabel.setText("Bity Nadawane");

        IloscGenerowanychBitowSpinner.setName("");
        IloscGenerowanychBitowSpinner.setPreferredSize(new java.awt.Dimension(50, 30));
        IloscGenerowanychBitowSpinner.setValue(1);

        BityNadawaneTextFieldLabel.setText("Bity");

        ZakodowaneLabel.setText("Zakodowane");

        GenerujButton.setText("GENERUJ");
        initGenerujButtonListener();

        KodujButton.setText("KODUJ");
        initKodujButtonListener();

        javax.swing.GroupLayout NadawaneBityLayout = new javax.swing.GroupLayout(NadawaneBityPanel);
        NadawaneBityPanel.setLayout(NadawaneBityLayout);
        NadawaneBityLayout.setHorizontalGroup(
                NadawaneBityLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(NadawaneBityLayout.createSequentialGroup()
                                .addGroup(NadawaneBityLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(BityNadawanePanelLabel)
                                        .addGroup(NadawaneBityLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addGroup(NadawaneBityLayout.createSequentialGroup()
                                                        .addComponent(IloscGenerowanychBitowSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(43, 43, 43)
                                                        .addComponent(GenerujButton)
                                                        .addGap(26, 26, 26)
                                                        .addComponent(KodujButton))
                                                .addGroup(NadawaneBityLayout.createSequentialGroup()
                                                        .addGroup(NadawaneBityLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addGroup(NadawaneBityLayout.createSequentialGroup()
                                                                        .addGap(14, 14, 14)
                                                                        .addComponent(ZakodowaneLabel))
                                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, NadawaneBityLayout.createSequentialGroup()
                                                                        .addContainerGap()
                                                                        .addComponent(BityNadawaneTextFieldLabel)))
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addGroup(NadawaneBityLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                .addComponent(BityTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 572, Short.MAX_VALUE)
                                                                .addComponent(ZakodowaneTextField)))))
                                .addGap(0, 25, Short.MAX_VALUE))
        );
        NadawaneBityLayout.setVerticalGroup(
                NadawaneBityLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(NadawaneBityLayout.createSequentialGroup()
                                .addComponent(BityNadawanePanelLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(NadawaneBityLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(BityNadawaneTextFieldLabel)
                                        .addComponent(BityTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(NadawaneBityLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(IloscGenerowanychBitowSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(GenerujButton)
                                        .addComponent(KodujButton))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(NadawaneBityLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(ZakodowaneTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(ZakodowaneLabel))
                                .addGap(28, 28, 28))
        );
    }

    private void initGenerujButtonListener() {
        GenerujButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BityTextField.setText(
                        simulationRunner.generate(Integer.parseInt(
                                IloscGenerowanychBitowSpinner
                                        .getValue()
                                        .toString()
                        )));
            }
        });

    }

    private void initKodujButtonListener() {
        KodujButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                simulationRunner.encode(BityTextField.getText());
                ZakodowaneTextField.setText(simulationRunner.getEncoded());
            }
        });
    }

    private void initOdbieranePanel() {
        BityOdbieranePanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        BityOdbieranePanel.setPreferredSize(new java.awt.Dimension(900, 300));

        BityOdbieraneLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        BityOdbieraneLabel.setText("Bity Odbierane");
        ZakloconeLabel.setText("Zakłócone");
        IloscZaklocanychBitowSpinner.setPreferredSize(new java.awt.Dimension(50, 30));

        ZaklocButton.setText("ZAKŁÓĆ");
        initZaklocButtonListener();

        DekodujButton.setText("DEKODUJ");
        initDekodujButtonListener();

        OdkodowaneLabel.setText("Odkodowane");

        javax.swing.GroupLayout OdbieraneBityLayout = new javax.swing.GroupLayout(BityOdbieranePanel);
        BityOdbieranePanel.setLayout(OdbieraneBityLayout);
        OdbieraneBityLayout.setHorizontalGroup(
                OdbieraneBityLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                        .addGroup(OdbieraneBityLayout.createSequentialGroup()
                                .addComponent(BityOdbieraneLabel)
                                .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, OdbieraneBityLayout.createSequentialGroup()
                                .addGroup(OdbieraneBityLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, OdbieraneBityLayout.createSequentialGroup()
                                                .addGap(16, 16, 16)
                                                .addGroup(OdbieraneBityLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(OdbieraneBityLayout.createSequentialGroup()
                                                                .addComponent(OdkodowaneLabel)
                                                                .addGap(29, 29, 29)
                                                                .addComponent(OdkodowaneTextField))
                                                        .addGroup(OdbieraneBityLayout.createSequentialGroup()
                                                                .addComponent(ZakloconeLabel)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(ZakloconeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 569, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGroup(OdbieraneBityLayout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addGroup(OdbieraneBityLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, OdbieraneBityLayout.createSequentialGroup()
                                                                .addComponent(IloscZaklocanychBitowSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(35, 35, 35)
                                                                .addComponent(ZaklocButton)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(DekodujButton)))))
                                .addGap(26, 26, 26))
        );
        OdbieraneBityLayout.setVerticalGroup(
                OdbieraneBityLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(OdbieraneBityLayout.createSequentialGroup()
                                .addComponent(BityOdbieraneLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(OdbieraneBityLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(ZakloconeLabel)
                                        .addComponent(ZakloconeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(OdbieraneBityLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(IloscZaklocanychBitowSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(ZaklocButton)
                                        .addComponent(DekodujButton))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(OdbieraneBityLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(OdkodowaneLabel)
                                        .addComponent(OdkodowaneTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(30, Short.MAX_VALUE))
        );
    }

    private void initDekodujButtonListener() {
        DekodujButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(ZakloconeTextField.getText().isEmpty()){
                    simulationRunner.decode(ZakodowaneTextField.getText());
                }else{
                    simulationRunner.decode(ZakloconeTextField.getText());
                }

                OdkodowaneTextField.setText(simulationRunner.getDecoded());
                PrzeslaneBityTextField.setText(simulationRunner.getNumberOfEncodedBits());
                WykryteBledyTextField.setText(simulationRunner.getNumberOfDetectedErrors());
                BityNadmiaroweTextField.setText(simulationRunner.getRedundantBitsNumber());
                SkorygowaneBledyTextField.setText(simulationRunner.getNumberOfCorrectedErrors());
                NiewykryteBledyTextField.setText(simulationRunner.getNumberOfUndetectedErrors());
            }
        });

    }

    private void initZaklocButtonListener() {
        ZaklocButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                simulationRunner.disrupt(
                        ZakodowaneTextField.getText(),
                        Integer.parseInt(IloscZaklocanychBitowSpinner.getValue().toString())
                );
                ZakloconeTextField.setText(simulationRunner.getDisrupted());
            }
        });
    }

    private void initPodsumowaniePanel() {
        PodsumowaniePanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        PodsumowaniePanel.setPreferredSize(new java.awt.Dimension(900, 150));

        PodsumowanieLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        PodsumowanieLabel.setText("Podsumowanie");

        PrzeslaneBityDanychLabel.setText("Przesłane bity danych");
        BledyWykryteLabel.setText("Błędy wykryte");
        PrzeslaneBityNadmiaroweLabel.setText("Przesłane bity nadmiarowe");
        BledySkorygowaneLabel.setText("Błędy skorygowane");
        BledyNiewykryteLabel.setText("Błędy niewykryte");

        WyczyscButton.setText("WYCZYŚĆ I RESETUJ");
        initWyczyscButtonListener();

        javax.swing.GroupLayout OstatnieLayout = new javax.swing.GroupLayout(PodsumowaniePanel);
        PodsumowaniePanel.setLayout(OstatnieLayout);
        OstatnieLayout.setHorizontalGroup(
            OstatnieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(OstatnieLayout.createSequentialGroup()
                .addComponent(PodsumowanieLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(OstatnieLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(OstatnieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BledyWykryteLabel)
                    .addComponent(PrzeslaneBityDanychLabel)
                    .addComponent(PrzeslaneBityNadmiaroweLabel))
                .addGap(13, 13, 13)
                .addGroup(OstatnieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(PrzeslaneBityTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                    .addComponent(WykryteBledyTextField)
                    .addComponent(BityNadmiaroweTextField))
                .addGap(18, 18, 18)
                .addGroup(OstatnieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(OstatnieLayout.createSequentialGroup()
                        .addGroup(OstatnieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(BledySkorygowaneLabel)
                            .addComponent(BledyNiewykryteLabel))
                        .addGap(18, 18, 18)
                        .addGroup(OstatnieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(SkorygowaneBledyTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                            .addComponent(NiewykryteBledyTextField))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, OstatnieLayout.createSequentialGroup()
                        .addGap(0, 287, Short.MAX_VALUE)
                        .addComponent(WyczyscButton)
                        .addGap(57, 57, 57))))
        );
        OstatnieLayout.setVerticalGroup(
            OstatnieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(OstatnieLayout.createSequentialGroup()
                .addComponent(PodsumowanieLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(OstatnieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PrzeslaneBityDanychLabel)
                    .addComponent(PrzeslaneBityTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BledySkorygowaneLabel)
                    .addComponent(SkorygowaneBledyTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(OstatnieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BledyWykryteLabel)
                    .addComponent(WykryteBledyTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BledyNiewykryteLabel)
                    .addComponent(NiewykryteBledyTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(OstatnieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PrzeslaneBityNadmiaroweLabel)
                    .addComponent(BityNadmiaroweTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(WyczyscButton))
                .addGap(0, 30, Short.MAX_VALUE))
        );
    }

    private void initWyczyscButtonListener() {
        WyczyscButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                simulationRunner.resetRunner();
                BityTextField.setText("");
                ZakodowaneTextField.setText("");
                ZakloconeTextField.setText("");
                OdkodowaneTextField.setText("");
                OdkodowaneTextField.setText("");
                PrzeslaneBityTextField.setText("");
                WykryteBledyTextField.setText("");
                BityNadmiaroweTextField.setText("");
                SkorygowaneBledyTextField.setText("");
                NiewykryteBledyTextField.setText("");
            }
        });
    }

    private void initLayout() {
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                                        .addComponent(MetodaDetekcjiKorekcjiPanel, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.PREFERRED_SIZE, 880, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(NadawaneBityPanel, GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.PREFERRED_SIZE, 880, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(BityOdbieranePanel, GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.PREFERRED_SIZE, 880, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(PodsumowaniePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 880, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(MetodaDetekcjiKorekcjiPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(4, 4, 4)
                                .addComponent(NadawaneBityPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BityOdbieranePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(PodsumowaniePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
    }

}
