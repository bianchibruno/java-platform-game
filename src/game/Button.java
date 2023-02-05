//package game;
//
//import game.Game;
//import game.MyView;
//
//
//public class Button extends javax.swing.JPanel {
//    private Game game;
//    private MyView view;
//
//
//    public Button(Game game,MyView view) {
//        initComponents();
//        this.game=game;
//        this.view=view;
//
//
//        private void initComponents() {
//            pauseGame = new javax.swing.JButton();
//            resumeGame = new javax.swing.JButton();
//
//
//            pauseGame.setText("Pause Game");
//            pauseGame.addActionListener(new java.awt.event.ActionListener() {
//                public void actionPerformed(java.awt.event.ActionEvent evt) {
//                    pauseGameActionPerformed(evt);
//                }
//            });
//
//            resumeGame.setText("Resume Game");
//            resumeGame.addActionListener(new java.awt.event.ActionListener() {
//                public void actionPerformed(java.awt.event.ActionEvent evt) {
//                    resumeGameActionPerformed(evt);
//                }
//            });
//
//
//            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
//            this.setLayout(layout);
//            layout.setHorizontalGroup(
//                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                            .addGroup(layout.createSequentialGroup()
//                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                                            .addGroup(layout.createSequentialGroup()
//                                                    .addGap(21, 21, 21)
//                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                                                            .addComponent(pauseGame)
//                                                            .addGroup(layout.createSequentialGroup()
//                                                                    .addContainerGap()
//                                                                    .addGroup(layout.createSequentialGroup()
//                                                                            .addGap(18, 18, 18)
//                                                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                                                                                    .addComponent(resumeGame)
//                                                                                    .addGroup(layout.createSequentialGroup()
//                                                                                            .addGap(6, 6, 6)
//                                                                                            .addContainerGap(11, Short.MAX_VALUE))
//                                                                            );
//
//
//            layout.setVerticalGroup(
//                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                            .addGroup(layout.createSequentialGroup()
//
//                                    .addComponent(pauseGame)
//                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
//                                    .addComponent(resumeGame)
//
//
//            private void pauseGameActionPerformed(java.awt.event.ActionEvent evt) {
//                game.getWorld().stop();
//
//
//                private void resumeGameActionPerformed(java.awt.event.ActionEvent evt) {
//                    game.getWorld().start();
//
//
//                    private javax.swing.JButton pauseGame;
//                    private javax.swing.JButton resumeGame;