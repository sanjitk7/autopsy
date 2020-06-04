/*
 * Autopsy
 *
 * Copyright 2020 Basis Technology Corp.
 * Contact: carrier <at> sleuthkit <dot> org
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.sleuthkit.autopsy.discovery;

import javax.swing.DefaultListModel;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JList;
import org.sleuthkit.autopsy.centralrepository.datamodel.CentralRepository;
import org.sleuthkit.autopsy.discovery.FileSearchData.Frequency;

final class PastOccurrencesFilterPanel extends AbstractDiscoveryFilterPanel {

    private static final long serialVersionUID = 1L;

    /**
     * Creates new form PastOccurrencesFilterPanel
     */
    PastOccurrencesFilterPanel() {
        initComponents();
        setUpFrequencyFilter();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pastOccurrencesCheckbox = new javax.swing.JCheckBox();
        crFrequencyScrollPane = new javax.swing.JScrollPane();
        crFrequencyList = new javax.swing.JList<>();

        org.openide.awt.Mnemonics.setLocalizedText(pastOccurrencesCheckbox, org.openide.util.NbBundle.getMessage(PastOccurrencesFilterPanel.class, "PastOccurrencesFilterPanel.pastOccurrencesCheckbox.text")); // NOI18N
        pastOccurrencesCheckbox.setMaximumSize(new java.awt.Dimension(150, 25));
        pastOccurrencesCheckbox.setMinimumSize(new java.awt.Dimension(150, 25));
        pastOccurrencesCheckbox.setPreferredSize(new java.awt.Dimension(150, 25));
        pastOccurrencesCheckbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pastOccurrencesCheckboxActionPerformed(evt);
            }
        });

        setMinimumSize(new java.awt.Dimension(250, 30));
        setPreferredSize(new java.awt.Dimension(250, 30));

        crFrequencyScrollPane.setPreferredSize(new java.awt.Dimension(27, 27));

        crFrequencyList.setModel(new DefaultListModel<Frequency>());
        crFrequencyList.setEnabled(false);
        crFrequencyList.setVisibleRowCount(5);
        crFrequencyScrollPane.setViewportView(crFrequencyList);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(crFrequencyScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(crFrequencyScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void pastOccurrencesCheckboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pastOccurrencesCheckboxActionPerformed
        crFrequencyList.setEnabled(pastOccurrencesCheckbox.isSelected());
    }//GEN-LAST:event_pastOccurrencesCheckboxActionPerformed

    /**
     * Initialize the frequency filter
     */
    private void setUpFrequencyFilter() {
        int count = 0;
        DefaultListModel<FileSearchData.Frequency> frequencyListModel = (DefaultListModel<FileSearchData.Frequency>) crFrequencyList.getModel();
        frequencyListModel.removeAllElements();
        if (!CentralRepository.isEnabled()) {
            for (FileSearchData.Frequency freq : FileSearchData.Frequency.getOptionsForFilteringWithoutCr()) {
                frequencyListModel.add(count, freq);
            }
        } else {
            for (FileSearchData.Frequency freq : FileSearchData.Frequency.getOptionsForFilteringWithCr()) {
                frequencyListModel.add(count, freq);
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<Frequency> crFrequencyList;
    private javax.swing.JScrollPane crFrequencyScrollPane;
    private javax.swing.JCheckBox pastOccurrencesCheckbox;
    // End of variables declaration//GEN-END:variables

    @Override
    void configurePanel(boolean selected, int[] indicesSelected) {
        pastOccurrencesCheckbox.setSelected(selected);
        if (pastOccurrencesCheckbox.isEnabled() && pastOccurrencesCheckbox.isSelected()) {
            crFrequencyScrollPane.setEnabled(true);
            crFrequencyList.setEnabled(true);
            if (indicesSelected != null) {
                crFrequencyList.setSelectedIndices(indicesSelected);
            }
        } else {
            crFrequencyScrollPane.setEnabled(false);
            crFrequencyList.setEnabled(false);
        }
    }

    @Override
    JCheckBox getCheckbox() {
        return pastOccurrencesCheckbox;
    }

    @Override
    JLabel getAdditionalLabel() {
        return null;
    }

    @Override
    String checkForError() {
        if (pastOccurrencesCheckbox.isSelected() && crFrequencyList.getSelectedValuesList().isEmpty()) {
            return "At least one CR frequency must be selected";
        }
        return null;
    }

    @Override
    JList<?> getList() {
        return crFrequencyList;
    }

    @Override
    FileSearchFiltering.FileFilter getFilter() {
        if (pastOccurrencesCheckbox.isSelected()) {
            return new FileSearchFiltering.FrequencyFilter(crFrequencyList.getSelectedValuesList());
        }
        return null;
    }
}
