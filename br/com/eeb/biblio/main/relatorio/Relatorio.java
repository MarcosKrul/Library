/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.eeb.biblio.main.relatorio;
import br.com.eeb.biblio.main.classes.Livro;
import br.com.eeb.biblio.main.table.TabelaInternal;
import java.awt.Color;

/**
 *
 * @author marco
 */
public class Relatorio extends javax.swing.JInternalFrame {

    /**
     * Creates new form Relatorio
     */
    
    TabelaInternal modeloInternal;
    private Livro livro;
    
    public Relatorio(Livro l) {
        initComponents();
        tabela_relatorio.setModel(modeloInternal);
        this.livro = l;
        modeloInternal = new TabelaInternal(l.getNome(), l);
        this.gerarRelatorio();
    }
    
    public void gerarRelatorio(){
        cp_nome.setText(livro.getNome());
        cp_editora.setText(livro.getEditora());
        cp_paginas.setText(Integer.toString(livro.getPaginas()));
        cp_estoque.setText(Integer.toString(livro.getQuantidadeEstoque()));
        cp_disponivel.setText(Integer.toString(livro.getQuantidadeDisponivel()));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        relatorio_painel_fundo = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela_relatorio = new javax.swing.JTable();
        btn_internal_voltar = new javax.swing.JButton();
        cp_nome = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cp_editora = new javax.swing.JLabel();
        cp_paginas = new javax.swing.JLabel();
        cp_estoque = new javax.swing.JLabel();
        cp_disponivel = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();

        setClosable(true);

        relatorio_painel_fundo.setBackground(new java.awt.Color(79, 79, 79));

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Nome do livro:");

        tabela_relatorio.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tabela_relatorio);

        btn_internal_voltar.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        btn_internal_voltar.setText("Voltar");
        btn_internal_voltar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_internal_voltarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_internal_voltarMouseExited(evt);
            }
        });
        btn_internal_voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_internal_voltarActionPerformed(evt);
            }
        });

        cp_nome.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        cp_nome.setForeground(new java.awt.Color(255, 255, 255));
        cp_nome.setText("jLabel2");

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Editora:");

        jLabel3.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Quantidade de páginas:");

        jLabel4.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Quantidade em estoque:");

        jLabel5.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Quantidade disponível:");

        cp_editora.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        cp_editora.setForeground(new java.awt.Color(255, 255, 255));
        cp_editora.setText("jLabel6");

        cp_paginas.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        cp_paginas.setForeground(new java.awt.Color(255, 255, 255));
        cp_paginas.setText("jLabel7");

        cp_estoque.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        cp_estoque.setForeground(new java.awt.Color(255, 255, 255));
        cp_estoque.setText("jLabel8");

        cp_disponivel.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        cp_disponivel.setForeground(new java.awt.Color(255, 255, 255));
        cp_disponivel.setText("jLabel9");

        jLabel6.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel6.setText("Relatório de empréstimos");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(304, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(342, 342, 342))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel6))
        );

        javax.swing.GroupLayout relatorio_painel_fundoLayout = new javax.swing.GroupLayout(relatorio_painel_fundo);
        relatorio_painel_fundo.setLayout(relatorio_painel_fundoLayout);
        relatorio_painel_fundoLayout.setHorizontalGroup(
            relatorio_painel_fundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(relatorio_painel_fundoLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(relatorio_painel_fundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(relatorio_painel_fundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(relatorio_painel_fundoLayout.createSequentialGroup()
                        .addComponent(cp_nome, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
                        .addGap(276, 276, 276))
                    .addGroup(relatorio_painel_fundoLayout.createSequentialGroup()
                        .addGroup(relatorio_painel_fundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cp_paginas)
                            .addComponent(cp_editora))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(relatorio_painel_fundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(relatorio_painel_fundoLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cp_estoque))
                    .addGroup(relatorio_painel_fundoLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cp_disponivel)))
                .addGap(87, 87, 87))
            .addGroup(relatorio_painel_fundoLayout.createSequentialGroup()
                .addGroup(relatorio_painel_fundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(relatorio_painel_fundoLayout.createSequentialGroup()
                        .addGap(195, 195, 195)
                        .addComponent(btn_internal_voltar, javax.swing.GroupLayout.PREFERRED_SIZE, 552, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(relatorio_painel_fundoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(relatorio_painel_fundoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        relatorio_painel_fundoLayout.setVerticalGroup(
            relatorio_painel_fundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(relatorio_painel_fundoLayout.createSequentialGroup()
                .addGroup(relatorio_painel_fundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(relatorio_painel_fundoLayout.createSequentialGroup()
                        .addGroup(relatorio_painel_fundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(relatorio_painel_fundoLayout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(cp_estoque))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, relatorio_painel_fundoLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel4)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(relatorio_painel_fundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cp_disponivel)
                            .addComponent(jLabel5)))
                    .addGroup(relatorio_painel_fundoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(relatorio_painel_fundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(cp_nome))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(relatorio_painel_fundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(cp_editora))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(relatorio_painel_fundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(cp_paginas))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_internal_voltar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(relatorio_painel_fundo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(relatorio_painel_fundo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_internal_voltarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_internal_voltarMouseEntered
        btn_internal_voltar.setBackground(Color.GREEN);
        btn_internal_voltar.setForeground(Color.WHITE);
    }//GEN-LAST:event_btn_internal_voltarMouseEntered

    private void btn_internal_voltarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_internal_voltarMouseExited
        btn_internal_voltar.setBackground(Color.WHITE);
        btn_internal_voltar.setForeground(Color.BLACK);
    }//GEN-LAST:event_btn_internal_voltarMouseExited

    private void btn_internal_voltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_internal_voltarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btn_internal_voltarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_internal_voltar;
    private javax.swing.JLabel cp_disponivel;
    private javax.swing.JLabel cp_editora;
    private javax.swing.JLabel cp_estoque;
    private javax.swing.JLabel cp_nome;
    private javax.swing.JLabel cp_paginas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel relatorio_painel_fundo;
    private javax.swing.JTable tabela_relatorio;
    // End of variables declaration//GEN-END:variables
}