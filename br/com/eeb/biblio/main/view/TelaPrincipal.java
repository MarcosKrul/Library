
package br.com.eeb.biblio.main.view;
import br.com.eeb.biblio.file.FileControll;
import br.com.eeb.biblio.file.FileHelp;
import br.com.eeb.biblio.login.JTextFieldHint;
import br.com.eeb.biblio.main.classes.Aluno;
import br.com.eeb.biblio.main.classes.Livro;
import br.com.eeb.biblio.main.table.TabelaMain;
import java.awt.Color;
import java.awt.Font;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author marco
 */
public class TelaPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form TelaPrincipal
     */
    
    private final TabelaMain modelo;
    private final String fDir;
    private static boolean corBotao = true;        //true - black; false - white
    
    public TelaPrincipal() {
        initComponents();
        setLocationRelativeTo(null);
        modelo = new TabelaMain();
        tabela_lista.setModel(modelo);
        tabela_biblio.setModel(modelo);
        fDir = "C:\\Library\\main\\file\\regLab_EEBAB.txt";
        try{
            for(Livro aux: FileControll.fread(fDir))
                modelo.addRow(aux);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro no arquivo");
            e.printStackTrace();
        }
        btn_chg_enviar.setEnabled(false);
        btn_chg_cancelar.setEnabled(false);
        btn_cancelar.setBackground(new Color(240, 240, 240));
        btn_enviar.setBackground(new Color(240, 240, 240));
        jTabbedPane1.setBackground(new Color(240,240,240));
        
        Timer timer = new Timer();
        TimerTask att = new TimerTask(){
            @Override
            public void run() {
                Calendar c = Calendar.getInstance();
                if(corBotao) cp_data.setForeground(new Color(204,204,204));
                else cp_data.setForeground(new Color(176,196,222));
                SimpleDateFormat formato = new SimpleDateFormat("'Brasil', dd 'de' MMMM 'de' yyyy 'às' HH:mm:ss");
                cp_data.setText(formato.format(c.getTime()));
            }
        };
        timer.scheduleAtFixedRate(att, 0, 1000);
    }
    
    public void clearInput(){
        in_nomLivro.setText("");
        in_editora.setText("");
        in_paginas.setText("");
        in_qntEstoque.setText("");
    }
    
    public void clearInputChg(){
        chg_nome.setText("");
        chg_editora.setText("");
        chg_paginas.setText("");
        chg_quantidade.setText("");
    }
    
    public void confirmDelete(int index){
        if(index != -1){
            Livro l = modelo.livroControle(index);
            if(l.getQuantidadeDisponivel() != l.getQuantidadeEstoque()){
                JOptionPane.showMessageDialog(null, "Não é possível excluir um livro que possui unidades emprestadas");
                tabela_biblio.clearSelection();
                return;
            }
            int resposta = JOptionPane.showConfirmDialog(this, 
                    "Você tem certeza que deseja excluir este livro?", 
                    "Confirmação de exclusão", JOptionPane.YES_NO_OPTION);
            if(resposta == JOptionPane.YES_OPTION){
                modelo.removeRow(index);
                try{
                    FileControll.attDelte(fDir, index);
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(null, "Erro no arquivo ao tentar excluir. Por favor, contate o programador");
                }
                JOptionPane.showMessageDialog(null, "Livro excluído com sucesso!");
                tabela_biblio.clearSelection();
            } 
        } else {
            JOptionPane.showMessageDialog(null, "Por favor, selecione um livro para realizar esta operação");
            tabela_biblio.clearSelection();
        }
    }
    
    public void confirmAtt (int rowIndex) {
        try{
            FileControll.attChange(modelo.livroControle(rowIndex), fDir, rowIndex);
        } catch (IOException e){
            JOptionPane.showMessageDialog(null, "Erro no arquivo. Contato o programador");
            e.printStackTrace();
        }
    }
    
    public String data () {
        SimpleDateFormat sf = new SimpleDateFormat("dd.MM.yy HH.mm.ss");
        return sf.format(Calendar.getInstance().getTime());
    }
    
    private void suporteAbout(String name) {
        try {
            String out = "";
            for(String aux: FileHelp.read(name))
                out += aux+"\n";
            JOptionPane.showMessageDialog(null, out);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro no arquivo "+name+" da aplicação. Por favor, contate o programador");
            e.printStackTrace();
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Erro. Por favor, contate o programador");
            e.printStackTrace();
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painel_fundo = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        painel_cadastroLivros = new javax.swing.JPanel();
        painel_dadosCadastrais = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        in_nomLivro = new JTextFieldHint(new JTextField(), "", "Nome do livro");
        jLabel2 = new javax.swing.JLabel();
        in_editora = new JTextFieldHint(new JTextField(), "", "Nome da editora");
        jLabel3 = new javax.swing.JLabel();
        in_qntEstoque = new JTextFieldHint(new JTextField(), "", "Estoque");
        jLabel4 = new javax.swing.JLabel();
        in_paginas = new JTextFieldHint(new JTextField(), "", "Páginas");
        btn_enviar = new javax.swing.JButton();
        btn_cancelar = new javax.swing.JButton();
        cp_data = new javax.swing.JLabel();
        painel_tabela = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela_lista = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        chg_nome = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        chg_editora = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        chg_paginas = new javax.swing.JTextField();
        chg_quantidade = new javax.swing.JTextField();
        btn_chg_alterar = new javax.swing.JButton();
        btn_chg_enviar = new javax.swing.JButton();
        btn_chg_excluir = new javax.swing.JButton();
        btn_chg_cancelar = new javax.swing.JButton();
        painel_biblioteca = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabela_biblio = new javax.swing.JTable();
        btn_emprestimo = new javax.swing.JButton();
        btn_devolucao = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        intemMenu_qntLivros = new javax.swing.JMenuItem();
        itemMenu_qntUnidades = new javax.swing.JMenuItem();
        itemMenu_qntEmprestados = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        itemMenu_backup = new javax.swing.JMenuItem();
        itemMenu_zerar = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        itemMenu_temaClaro = new javax.swing.JMenuItem();
        itemMenu_temaEscuro = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        itemMenu_relatorio = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        itemMenu_help_cadastro = new javax.swing.JMenuItem();
        itemMenu_help_alterar = new javax.swing.JMenuItem();
        itemMenu_help_excluir = new javax.swing.JMenuItem();
        itemMenu_help_biblio = new javax.swing.JMenuItem();
        itemMenu_help_relatorio = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        itemMenu_sobre = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        painel_fundo.setBackground(new java.awt.Color(54, 54, 54));

        jTabbedPane1.setBackground(new java.awt.Color(79, 79, 79));

        painel_cadastroLivros.setBackground(new java.awt.Color(79, 79, 79));

        painel_dadosCadastrais.setBackground(new java.awt.Color(79, 79, 79));
        painel_dadosCadastrais.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados cadastrais", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 1, 14), new java.awt.Color(255, 255, 255))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Nome do livro");

        in_nomLivro.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        in_nomLivro.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nome da editora");

        in_editora.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        in_editora.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel3.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Quantidade em estoque");

        in_qntEstoque.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        in_qntEstoque.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel4.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Quantidade de páginas");

        in_paginas.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        in_paginas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btn_enviar.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        btn_enviar.setText("Enviar");
        btn_enviar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        btn_enviar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_enviar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_enviarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_enviarMouseExited(evt);
            }
        });
        btn_enviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_enviarActionPerformed(evt);
            }
        });

        btn_cancelar.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        btn_cancelar.setText("Cancelar/limpar");
        btn_cancelar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        btn_cancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_cancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_cancelarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_cancelarMouseExited(evt);
            }
        });
        btn_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painel_dadosCadastraisLayout = new javax.swing.GroupLayout(painel_dadosCadastrais);
        painel_dadosCadastrais.setLayout(painel_dadosCadastraisLayout);
        painel_dadosCadastraisLayout.setHorizontalGroup(
            painel_dadosCadastraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painel_dadosCadastraisLayout.createSequentialGroup()
                .addGroup(painel_dadosCadastraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(painel_dadosCadastraisLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(painel_dadosCadastraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(painel_dadosCadastraisLayout.createSequentialGroup()
                                .addGroup(painel_dadosCadastraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(painel_dadosCadastraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(in_paginas, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(in_qntEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(painel_dadosCadastraisLayout.createSequentialGroup()
                                .addGroup(painel_dadosCadastraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(painel_dadosCadastraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(in_nomLivro)
                                    .addComponent(in_editora)))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, painel_dadosCadastraisLayout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addComponent(btn_enviar, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 178, Short.MAX_VALUE)
                        .addComponent(btn_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(84, 84, 84))
        );
        painel_dadosCadastraisLayout.setVerticalGroup(
            painel_dadosCadastraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_dadosCadastraisLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painel_dadosCadastraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(painel_dadosCadastraisLayout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(in_nomLivro, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painel_dadosCadastraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(in_editora, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painel_dadosCadastraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(in_paginas, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addGroup(painel_dadosCadastraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                    .addComponent(in_qntEstoque))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(painel_dadosCadastraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_enviar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
        );

        cp_data.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        cp_data.setForeground(new java.awt.Color(204, 204, 204));
        cp_data.setText("jLabel9");

        javax.swing.GroupLayout painel_cadastroLivrosLayout = new javax.swing.GroupLayout(painel_cadastroLivros);
        painel_cadastroLivros.setLayout(painel_cadastroLivrosLayout);
        painel_cadastroLivrosLayout.setHorizontalGroup(
            painel_cadastroLivrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_cadastroLivrosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(painel_dadosCadastrais, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(painel_cadastroLivrosLayout.createSequentialGroup()
                .addGap(249, 249, 249)
                .addComponent(cp_data, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        painel_cadastroLivrosLayout.setVerticalGroup(
            painel_cadastroLivrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_cadastroLivrosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(painel_dadosCadastrais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                .addComponent(cp_data)
                .addGap(41, 41, 41))
        );

        jTabbedPane1.addTab("Cadastro de livros", painel_cadastroLivros);

        painel_tabela.setBackground(new java.awt.Color(79, 79, 79));

        tabela_lista.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        tabela_lista.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tabela_lista);

        jLabel5.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Nome do livro");

        chg_nome.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Nome da editora");

        chg_editora.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Número de páginas");

        jLabel8.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Quantidade em estoque");

        chg_paginas.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N

        chg_quantidade.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N

        btn_chg_alterar.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        btn_chg_alterar.setText("Alterar");
        btn_chg_alterar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_chg_alterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_chg_alterarActionPerformed(evt);
            }
        });

        btn_chg_enviar.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        btn_chg_enviar.setText("Enviar");
        btn_chg_enviar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_chg_enviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_chg_enviarActionPerformed(evt);
            }
        });

        btn_chg_excluir.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        btn_chg_excluir.setText("Excluir");
        btn_chg_excluir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_chg_excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_chg_excluirActionPerformed(evt);
            }
        });

        btn_chg_cancelar.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        btn_chg_cancelar.setText("Cancelar");
        btn_chg_cancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_chg_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_chg_cancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painel_tabelaLayout = new javax.swing.GroupLayout(painel_tabela);
        painel_tabela.setLayout(painel_tabelaLayout);
        painel_tabelaLayout.setHorizontalGroup(
            painel_tabelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_tabelaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painel_tabelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 923, Short.MAX_VALUE)
                    .addGroup(painel_tabelaLayout.createSequentialGroup()
                        .addGroup(painel_tabelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(painel_tabelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(chg_nome, javax.swing.GroupLayout.DEFAULT_SIZE, 364, Short.MAX_VALUE)
                            .addComponent(chg_editora))
                        .addGap(56, 56, 56)
                        .addGroup(painel_tabelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(painel_tabelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(chg_paginas)
                            .addComponent(chg_quantidade))))
                .addContainerGap())
            .addGroup(painel_tabelaLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(btn_chg_alterar, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btn_chg_enviar, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_chg_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(btn_chg_excluir, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );
        painel_tabelaLayout.setVerticalGroup(
            painel_tabelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_tabelaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(painel_tabelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(chg_nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(chg_paginas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painel_tabelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(chg_editora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(chg_quantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(painel_tabelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_chg_alterar)
                    .addComponent(btn_chg_enviar)
                    .addComponent(btn_chg_excluir)
                    .addComponent(btn_chg_cancelar))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Lista de livros", painel_tabela);

        painel_biblioteca.setBackground(new java.awt.Color(79, 79, 79));

        tabela_biblio.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        tabela_biblio.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tabela_biblio);

        btn_emprestimo.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        btn_emprestimo.setText("Empréstimo");
        btn_emprestimo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_emprestimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_emprestimoActionPerformed(evt);
            }
        });

        btn_devolucao.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        btn_devolucao.setText("Devolução");
        btn_devolucao.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_devolucao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_devolucaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painel_bibliotecaLayout = new javax.swing.GroupLayout(painel_biblioteca);
        painel_biblioteca.setLayout(painel_bibliotecaLayout);
        painel_bibliotecaLayout.setHorizontalGroup(
            painel_bibliotecaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_bibliotecaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 923, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(painel_bibliotecaLayout.createSequentialGroup()
                .addGap(104, 104, 104)
                .addComponent(btn_emprestimo, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_devolucao, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(106, 106, 106))
        );
        painel_bibliotecaLayout.setVerticalGroup(
            painel_bibliotecaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_bibliotecaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(painel_bibliotecaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_emprestimo)
                    .addComponent(btn_devolucao))
                .addGap(24, 24, 24))
        );

        jTabbedPane1.addTab("Biblioteca", painel_biblioteca);

        javax.swing.GroupLayout painel_fundoLayout = new javax.swing.GroupLayout(painel_fundo);
        painel_fundo.setLayout(painel_fundoLayout);
        painel_fundoLayout.setHorizontalGroup(
            painel_fundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_fundoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        painel_fundoLayout.setVerticalGroup(
            painel_fundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_fundoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jMenu1.setText("Arquivo");

        intemMenu_qntLivros.setText("Quantidade de livros");
        intemMenu_qntLivros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                intemMenu_qntLivrosActionPerformed(evt);
            }
        });
        jMenu1.add(intemMenu_qntLivros);

        itemMenu_qntUnidades.setText("Quantidade de unidades");
        itemMenu_qntUnidades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemMenu_qntUnidadesActionPerformed(evt);
            }
        });
        jMenu1.add(itemMenu_qntUnidades);

        itemMenu_qntEmprestados.setText("Quantidade de emprestados");
        itemMenu_qntEmprestados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemMenu_qntEmprestadosActionPerformed(evt);
            }
        });
        jMenu1.add(itemMenu_qntEmprestados);
        jMenu1.add(jSeparator1);

        itemMenu_backup.setText("Gerar backup");
        itemMenu_backup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemMenu_backupActionPerformed(evt);
            }
        });
        jMenu1.add(itemMenu_backup);

        itemMenu_zerar.setText("Reiniciar sistema");
        itemMenu_zerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemMenu_zerarActionPerformed(evt);
            }
        });
        jMenu1.add(itemMenu_zerar);

        jMenuBar1.add(jMenu1);

        jMenu3.setText("Editor");

        itemMenu_temaClaro.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_W, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        itemMenu_temaClaro.setText("Tema claro");
        itemMenu_temaClaro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemMenu_temaClaroActionPerformed(evt);
            }
        });
        jMenu3.add(itemMenu_temaClaro);

        itemMenu_temaEscuro.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        itemMenu_temaEscuro.setText("Tema escuro");
        itemMenu_temaEscuro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemMenu_temaEscuroActionPerformed(evt);
            }
        });
        jMenu3.add(itemMenu_temaEscuro);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("Relatorio");

        itemMenu_relatorio.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        itemMenu_relatorio.setText("Gerar relatório");
        itemMenu_relatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemMenu_relatorioActionPerformed(evt);
            }
        });
        jMenu4.add(itemMenu_relatorio);

        jMenuBar1.add(jMenu4);

        jMenu5.setText("Ajuda");

        itemMenu_help_cadastro.setText("Cadastro de livros");
        itemMenu_help_cadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemMenu_help_cadastroActionPerformed(evt);
            }
        });
        jMenu5.add(itemMenu_help_cadastro);

        itemMenu_help_alterar.setText("Alteração");
        itemMenu_help_alterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemMenu_help_alterarActionPerformed(evt);
            }
        });
        jMenu5.add(itemMenu_help_alterar);

        itemMenu_help_excluir.setText("Exclusão");
        itemMenu_help_excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemMenu_help_excluirActionPerformed(evt);
            }
        });
        jMenu5.add(itemMenu_help_excluir);

        itemMenu_help_biblio.setText("Biblioteca");
        itemMenu_help_biblio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemMenu_help_biblioActionPerformed(evt);
            }
        });
        jMenu5.add(itemMenu_help_biblio);

        itemMenu_help_relatorio.setText("Relatório");
        itemMenu_help_relatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemMenu_help_relatorioActionPerformed(evt);
            }
        });
        jMenu5.add(itemMenu_help_relatorio);

        jMenuBar1.add(jMenu5);

        jMenu2.setText("Sobre");
        jMenu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu2ActionPerformed(evt);
            }
        });

        itemMenu_sobre.setText("Sobre");
        itemMenu_sobre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemMenu_sobreActionPerformed(evt);
            }
        });
        jMenu2.add(itemMenu_sobre);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painel_fundo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painel_fundo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void jMenu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu2ActionPerformed
    }//GEN-LAST:event_jMenu2ActionPerformed

    private void itemMenu_sobreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemMenu_sobreActionPerformed
        suporteAbout("aboutDev.txt");
    }//GEN-LAST:event_itemMenu_sobreActionPerformed
    
    public void suporteRelatorio(int index){
        Livro l = modelo.livroControle(index);
        if(l.getQuantidadeDisponivel() == l.getQuantidadeEstoque()){
            JOptionPane.showMessageDialog(null, "Todas as unidades deste livro encontram-se no estoque");
            return;
        }
        
        ArrayList<Aluno> a = l.getAlunoEmprestou();
        String alunos = "<html><body>Relátorio de empréstimos do livro <i>'"+l.getNome()+
                        "' </i><br/><br/></body></html>";
        for(Aluno aux : a){
            alunos += "Nome: "+aux.getNome()+" - Série: "+aux.getSerie()+"º ano\n";
        }
        JOptionPane.showMessageDialog(null, alunos, "Relatório", JOptionPane.INFORMATION_MESSAGE);
    }
    
    private void itemMenu_relatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemMenu_relatorioActionPerformed
        int rowIndex = tabela_biblio.getSelectedRow();
        if(rowIndex != -1){
            suporteRelatorio(rowIndex);
            tabela_biblio.clearSelection();
            return;
        }
        rowIndex = tabela_lista.getSelectedRow();
        if(rowIndex != -1){
            suporteRelatorio(rowIndex);
            tabela_lista.clearSelection();
            return;
        }
        
        String nomeBusca = JOptionPane.showInputDialog("Informe o livro desejado", "");
        if(nomeBusca == null) return;
        int index = modelo.buscaLivro(nomeBusca);
        if(index == -1){
            JOptionPane.showMessageDialog(null, "Livro não encontrado");
            return;
        }
        suporteRelatorio(index);
        tabela_biblio.clearSelection();
    }//GEN-LAST:event_itemMenu_relatorioActionPerformed

    public Aluno inAluno(String name){
        Aluno a = null;
        String[] series = new String[9];
        for(int i=0 ; i<9 ; i++) series[i] = ((i+1)+"º ano");
        
        String nome = JOptionPane.showInputDialog("Informe o nome do aluno", "").trim();
        if(nome == null) return null;
        String escolhaSerie = (String) JOptionPane.showInputDialog(null, "Selecione a série do aluno", 
                name, JOptionPane.QUESTION_MESSAGE, null, series, series[0]);
        if(escolhaSerie == null) return null; 
        
        try{
            int serie = Integer.parseInt(escolhaSerie.substring(0, 1));
            a = new Aluno(nome, serie);
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Entrada inválida");
        }
        return a;
    }
    
    private void btn_devolucaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_devolucaoActionPerformed
        int rowIndex = this.tabela_biblio.getSelectedRow();
        if(rowIndex == -1){
            JOptionPane.showMessageDialog(null, "Por favor, selecione um livro para realizar esta operação");
            tabela_biblio.clearSelection();
            return;
        }
        Livro l = modelo.livroControle(rowIndex);
        if(l.getQuantidadeDisponivel() == l.getQuantidadeEstoque()){
            JOptionPane.showMessageDialog(null, "Todas as unidades deste livros encontram-se na biblioteca");
            tabela_biblio.clearSelection();
            return;
        }
        Aluno a = inAluno("Devolução");
        if(a != null){
            if(l.devolucao(a)){
                modelo.fireTableCellUpdated(rowIndex, 3);
                JOptionPane.showMessageDialog(null, "Livro devolvido com sucesso");
                confirmAtt(rowIndex);
            } else JOptionPane.showMessageDialog(null, "O aluno informado não emprestou o livro selecionado");
        } 
        tabela_biblio.clearSelection();
    }//GEN-LAST:event_btn_devolucaoActionPerformed

    private void btn_emprestimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_emprestimoActionPerformed
        int rowIndex = this.tabela_biblio.getSelectedRow();
        if(rowIndex == -1){
            JOptionPane.showMessageDialog(null, "Por favor, selecione um livro para realizar esta operação");
            tabela_biblio.clearSelection();
            return;
        }
        Livro l = modelo.livroControle(rowIndex);
        if(l.getQuantidadeDisponivel() == 0){
            JOptionPane.showMessageDialog(null, "Não há unidades deste livro disponíveis para empréstimo");
            tabela_biblio.clearSelection();
            return;
        }
        Aluno a = inAluno("Cadastro para empréstimo");
        if(a != null){
            if(l.emprestimo(a)){
                modelo.fireTableCellUpdated(rowIndex, 3);
                JOptionPane.showMessageDialog(null, "Livro emprestado com sucesso");
                confirmAtt(rowIndex);
            } else JOptionPane.showMessageDialog(null, "Não há unidades deste livro disponíveis para empréstimo");
        }
        tabela_biblio.clearSelection();
    }//GEN-LAST:event_btn_emprestimoActionPerformed

    private void btn_chg_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_chg_cancelarActionPerformed
        btn_chg_alterar.setEnabled(true);
        btn_chg_enviar.setEnabled(false);
        clearInputChg();
        btn_chg_cancelar.setEnabled(false);
        tabela_lista.clearSelection();
    }//GEN-LAST:event_btn_chg_cancelarActionPerformed

    private void btn_chg_excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_chg_excluirActionPerformed
        confirmDelete(tabela_lista.getSelectedRow());
    }//GEN-LAST:event_btn_chg_excluirActionPerformed

    private void btn_chg_enviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_chg_enviarActionPerformed
        int rowIndex = tabela_lista.getSelectedRow();
        if(rowIndex == -1) {
            JOptionPane.showMessageDialog(null, "Por favor, selecione um livro para realizar está operação");
            tabela_lista.clearSelection();
            return;
        }
        int resposta = JOptionPane.showConfirmDialog(this,
            "Os dados do livro selecionado serão alterados definitivamente",
            "Atualização de dados", JOptionPane.OK_CANCEL_OPTION);

        if(resposta == JOptionPane.OK_OPTION){
            try{

                int pgs = Integer.parseInt(chg_paginas.getText());
                if(pgs>=0)
                    modelo.setValueAt(pgs, rowIndex, 2);
                else {
                    JOptionPane.showMessageDialog(null, "Valores negativos são inválidos");
                    btn_chg_cancelarActionPerformed(evt);
                    tabela_lista.clearSelection();
                    return;
                }

                int qntEstoqueAnterior = (int) modelo.getValueAt(rowIndex, 4);
                int qntDisponivelAnterior = (int) modelo.getValueAt(rowIndex, 3);
                int qntEstoqueNova = Integer.parseInt(chg_quantidade.getText());
                int qntDisponivelNova;

                if(qntEstoqueNova>=0){
                    if(qntEstoqueNova >= qntEstoqueAnterior){
                        qntDisponivelNova = qntDisponivelAnterior + (qntEstoqueNova - qntEstoqueAnterior);
                        modelo.setValueAt(qntEstoqueNova, rowIndex, 4);
                        modelo.setValueAt(qntDisponivelNova, rowIndex, 3);
                    } else {
                        int qntEmprestado = qntEstoqueAnterior - qntDisponivelAnterior;
                        qntDisponivelNova = qntDisponivelAnterior - (qntEstoqueAnterior - qntEstoqueNova);
                        if(qntEstoqueNova >= qntEmprestado){
                            modelo.setValueAt(qntEstoqueNova, rowIndex, 4);
                            modelo.setValueAt(qntDisponivelNova, rowIndex, 3);
                        } else {
                            JOptionPane.showMessageDialog(null, "Não é possível diminuir o estoque antes de realizar a devolução");
                            btn_chg_cancelarActionPerformed(evt);
                            tabela_lista.clearSelection();
                            return;
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Valores negativos são inválidos");
                    btn_chg_cancelarActionPerformed(evt);
                    tabela_lista.clearSelection();
                    return;
                }
                
                modelo.setValueAt(chg_nome.getText(), rowIndex, 0);
                modelo.setValueAt(chg_editora.getText(), rowIndex, 1);
                
                confirmAtt(rowIndex);
                
                JOptionPane.showMessageDialog(null, "Dados alterados com sucesso!");
                btn_chg_enviar.setEnabled(false);
                btn_chg_alterar.setEnabled(true);
                btn_chg_cancelar.setEnabled(false);
                tabela_lista.clearSelection();
                clearInputChg();
            } catch(Exception e) {
                JOptionPane.showMessageDialog(null, "Entrada inválida");
            }
        } 
        tabela_lista.clearSelection();
    }//GEN-LAST:event_btn_chg_enviarActionPerformed

    private void btn_chg_alterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_chg_alterarActionPerformed
        int index = tabela_lista.getSelectedRow();
        if(index == -1){
            JOptionPane.showMessageDialog(null, "Por favor, selecione um livro para realizar esta operação");
            return;
        }
        btn_chg_alterar.setEnabled(false);
        btn_chg_enviar.setEnabled(true);
        btn_chg_cancelar.setEnabled(true);
        chg_nome.setText((String) modelo.getValueAt(index, 0));
        chg_editora.setText((String) modelo.getValueAt(index, 1));
        chg_paginas.setText(Integer.toString((int) modelo.getValueAt(index, 2)));
        chg_quantidade.setText(Integer.toString((int) modelo.getValueAt(index, 4)));
    }//GEN-LAST:event_btn_chg_alterarActionPerformed

    private void btn_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelarActionPerformed
        clearInput();
    }//GEN-LAST:event_btn_cancelarActionPerformed

    private void btn_cancelarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_cancelarMouseExited
        if(corBotao){
            btn_cancelar.setBackground(new Color(240, 240, 240));
            btn_cancelar.setForeground(Color.BLACK);
        } else {
            btn_cancelar.setBackground(new Color(176,196,222));
            btn_cancelar.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_btn_cancelarMouseExited

    private void btn_cancelarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_cancelarMouseEntered
        btn_cancelar.setBackground(Color.RED);
        btn_cancelar.setForeground(Color.WHITE);
    }//GEN-LAST:event_btn_cancelarMouseEntered

    private void btn_enviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_enviarActionPerformed
        try{
            String nome, editora;
            int qnt, paginas;

            nome = in_nomLivro.getText().trim();
            editora = in_editora.getText();
            qnt = Integer.parseInt(in_qntEstoque.getText());
            paginas = Integer.parseInt(in_paginas.getText());

            if(paginas>0 && qnt>0){
                Livro l = new Livro(nome, editora, qnt, qnt, paginas);
                for(Livro aux : modelo.getDados())
                    if(l.equals(aux)) {
                        JOptionPane.showMessageDialog(null, "O livro infomado já está cadastrado");
                        clearInput();
                        return;
                    }
                modelo.addRow(l);
                FileControll.fwrite(l.toString(), fDir, true);
                JOptionPane.showMessageDialog(null, "Livro cadastrado com sucesso!");
                clearInput();
            } else JOptionPane.showMessageDialog(null, "Valores negativos são inválidos. Por favor, informe um valor positivo",
                    "Entrada inválida", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro no arquivo. Contate o programador");
        }catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Entrada inválida. Por favor, revise os dados", "Erro na entrada", 
                    JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btn_enviarActionPerformed

    private void btn_enviarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_enviarMouseExited
        if(corBotao){
            btn_enviar.setBackground(new Color(240, 240, 240));
            btn_enviar.setForeground(Color.BLACK);
        } else {
            btn_enviar.setBackground(new Color(176,196,222));
            btn_enviar.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_btn_enviarMouseExited

    private void btn_enviarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_enviarMouseEntered
            btn_enviar.setBackground(Color.GREEN);
            btn_enviar.setForeground(Color.WHITE);
    }//GEN-LAST:event_btn_enviarMouseEntered

    private JLabel[] labes(){
        JLabel [] labes = new JLabel[]{jLabel1, jLabel2, jLabel3,
        jLabel4, jLabel5, jLabel6, jLabel7, jLabel8};
        return labes;
    }
    
    private void itemMenu_temaClaroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemMenu_temaClaroActionPerformed
        corBotao = false;
        painel_fundo.setBackground(new Color(119,136,153));
        painel_cadastroLivros.setBackground(new Color(240,240,240));
        painel_dadosCadastrais.setBackground(new Color(240,240,240));
        painel_tabela.setBackground(new Color(240,240,240));
        painel_biblioteca.setBackground(new Color(240,240,240));
        btn_enviar.setBackground(new Color(176,196,222));
        btn_cancelar.setBackground(new Color(176,196,222));
        painel_dadosCadastrais.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados cadastrais", 
                javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, 
                new Font("Verdana", Font.BOLD, 14), Color.BLACK));
        for(JLabel aux: labes()){
            aux.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_itemMenu_temaClaroActionPerformed

    private void itemMenu_temaEscuroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemMenu_temaEscuroActionPerformed
        corBotao = true;
        painel_fundo.setBackground(new Color(54,54,54));
        painel_cadastroLivros.setBackground(new Color(79,79,79));
        painel_dadosCadastrais.setBackground(new Color(79,79,79));
        painel_tabela.setBackground(new Color(79,79,79));
        painel_biblioteca.setBackground(new Color(79,79,79));
        btn_enviar.setBackground(new Color(240,240,240));
        btn_cancelar.setBackground(new Color(240,240,240));
        painel_dadosCadastrais.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados cadastrais", 
                javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, 
                new Font("Verdana", Font.BOLD, 14), Color.WHITE));
        for(JLabel aux: labes()){
            aux.setForeground(Color.WHITE);
        }
    }//GEN-LAST:event_itemMenu_temaEscuroActionPerformed

    private void itemMenu_zerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemMenu_zerarActionPerformed
        JOptionPane.showMessageDialog(null, "Caro usuário!\nA reinicialização do sistema fará com que o programa não "
                + "carregue os livros já cadastros e seus respectivos registros.\nO arquivo será transferido a outro "
                + "diretório, o qual não está no escopo do programa.");
        int resposta = JOptionPane.showConfirmDialog(null, "Você tem certeza que deseja reiniciar o sistema?", 
                "Confirmação de reinicialização", JOptionPane.YES_NO_OPTION);
        if(resposta == JOptionPane.YES_OPTION){
            try {
                FileControll.restart("C:\\Library\\restart_"+data(), fDir);
                JOptionPane.showMessageDialog(null, "O programa precisa ser fechado para concluir a reinicialização.");
                System.exit(0);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Erro ao executar reinicialização. Por favor, contate o programador");
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_itemMenu_zerarActionPerformed

    private void itemMenu_backupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemMenu_backupActionPerformed
        try {
            FileControll.backup("C:\\Library\\backup_"+data(), fDir);
            JOptionPane.showMessageDialog(null, "Backup conluído com sucesso");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro ao executar o backup. Por favor, contate o programador");
            e.printStackTrace();
        }
    }//GEN-LAST:event_itemMenu_backupActionPerformed
    
    private void intemMenu_qntLivrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_intemMenu_qntLivrosActionPerformed
        JOptionPane.showMessageDialog(null, "Quantidade atual de livros diferentes na biblioteca: "+modelo.getRowCount());
    }//GEN-LAST:event_intemMenu_qntLivrosActionPerformed

    private void itemMenu_qntUnidadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemMenu_qntUnidadesActionPerformed
        JOptionPane.showMessageDialog(null, "Quantidade atual de unidades de livros na biblioteca: "+modelo.qntEstoque());
    }//GEN-LAST:event_itemMenu_qntUnidadesActionPerformed

    private void itemMenu_qntEmprestadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemMenu_qntEmprestadosActionPerformed
        JOptionPane.showMessageDialog(null, "Quantidade atual de livros emprestados da biblioteca: "+modelo.qntDisponivel());
    }//GEN-LAST:event_itemMenu_qntEmprestadosActionPerformed

    private void itemMenu_help_cadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemMenu_help_cadastroActionPerformed
        suporteAbout("aboutCad.txt");
    }//GEN-LAST:event_itemMenu_help_cadastroActionPerformed

    private void itemMenu_help_alterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemMenu_help_alterarActionPerformed
        suporteAbout("aboutSub.txt");
    }//GEN-LAST:event_itemMenu_help_alterarActionPerformed

    private void itemMenu_help_excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemMenu_help_excluirActionPerformed
        suporteAbout("aboutExcluir.txt");
    }//GEN-LAST:event_itemMenu_help_excluirActionPerformed

    private void itemMenu_help_biblioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemMenu_help_biblioActionPerformed
        suporteAbout("aboutBiblio.txt");
    }//GEN-LAST:event_itemMenu_help_biblioActionPerformed

    private void itemMenu_help_relatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemMenu_help_relatorioActionPerformed
        suporteAbout("aboutRel.txt");
    }//GEN-LAST:event_itemMenu_help_relatorioActionPerformed

    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cancelar;
    private javax.swing.JButton btn_chg_alterar;
    private javax.swing.JButton btn_chg_cancelar;
    private javax.swing.JButton btn_chg_enviar;
    private javax.swing.JButton btn_chg_excluir;
    private javax.swing.JButton btn_devolucao;
    private javax.swing.JButton btn_emprestimo;
    private javax.swing.JButton btn_enviar;
    private javax.swing.JTextField chg_editora;
    private javax.swing.JTextField chg_nome;
    private javax.swing.JTextField chg_paginas;
    private javax.swing.JTextField chg_quantidade;
    private javax.swing.JLabel cp_data;
    private javax.swing.JTextField in_editora;
    private javax.swing.JTextField in_nomLivro;
    private javax.swing.JTextField in_paginas;
    private javax.swing.JTextField in_qntEstoque;
    private javax.swing.JMenuItem intemMenu_qntLivros;
    private javax.swing.JMenuItem itemMenu_backup;
    private javax.swing.JMenuItem itemMenu_help_alterar;
    private javax.swing.JMenuItem itemMenu_help_biblio;
    private javax.swing.JMenuItem itemMenu_help_cadastro;
    private javax.swing.JMenuItem itemMenu_help_excluir;
    private javax.swing.JMenuItem itemMenu_help_relatorio;
    private javax.swing.JMenuItem itemMenu_qntEmprestados;
    private javax.swing.JMenuItem itemMenu_qntUnidades;
    private javax.swing.JMenuItem itemMenu_relatorio;
    private javax.swing.JMenuItem itemMenu_sobre;
    private javax.swing.JMenuItem itemMenu_temaClaro;
    private javax.swing.JMenuItem itemMenu_temaEscuro;
    private javax.swing.JMenuItem itemMenu_zerar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JPanel painel_biblioteca;
    private javax.swing.JPanel painel_cadastroLivros;
    private javax.swing.JPanel painel_dadosCadastrais;
    private javax.swing.JPanel painel_fundo;
    private javax.swing.JPanel painel_tabela;
    private javax.swing.JTable tabela_biblio;
    private javax.swing.JTable tabela_lista;
    // End of variables declaration//GEN-END:variables
}
