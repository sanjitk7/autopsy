/*
 * Autopsy Forensic Browser
 *
 * Copyright 2019 Basis Technology Corp.
 * Contact: carrier <at> sleuthkit <dot> org
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obt ain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.sleuthkit.autopsy.communications;

import javax.swing.JPanel;
import org.openide.util.lookup.ServiceProvider;

/**
 * Visualization for contacts
 * 
 */
@ServiceProvider(service=RelationshipsViewer.class)
public class ContactsViewer extends JPanel implements RelationshipsViewer{

    /**
     * Creates new form ContactsViewer
     */
    public ContactsViewer() {
        initComponents();
    }
    
    @Override
    public String getDisplayName() {
        return "Contacts";
    }
    
    @Override
    public JPanel getPanel() {
        return this;
    }
    
    @Override
    public void setSelectionInfo(SelectionInfo info) {
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        testLabel = new javax.swing.JLabel();

        org.openide.awt.Mnemonics.setLocalizedText(testLabel, org.openide.util.NbBundle.getMessage(ContactsViewer.class, "ContactsViewer.testLabel.text")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(testLabel)
                .addContainerGap(294, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(testLabel)
                .addContainerGap(264, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel testLabel;
    // End of variables declaration//GEN-END:variables
}
