/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package org.apache.jmeter.gui.util;

import java.awt.Component;

import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;

/**
 * Wraps {@link TableCellRenderer} to renders items in a JTable by using resource names
 * and control some formatting (centering, fonts and border)
 */
public class HeaderAsPropertyRendererWrapper implements TableCellRenderer {

    private Object[][] columnsMsgParameters;

    private TableCellRenderer delegate;

    /**
     * @param renderer {@link TableCellRenderer} to delegate to
     * @param columnsMsgParameters Optional parameters of i18n keys
     */
    public HeaderAsPropertyRendererWrapper(TableCellRenderer renderer, Object[][] columnsMsgParameters) {
        this.delegate = renderer;
        this.columnsMsgParameters = columnsMsgParameters;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {
        if(delegate instanceof DefaultTableCellRenderer) {
            DefaultTableCellRenderer tr = (DefaultTableCellRenderer) delegate;
            if (table != null) {
                JTableHeader header = table.getTableHeader();
                if (header != null){
                    tr.setForeground(header.getForeground());
                    tr.setBackground(header.getBackground());
                    tr.setFont(header.getFont());
                }
            }
            tr.setBorder(UIManager.getBorder("TableHeader.cellBorder"));
            tr.setHorizontalAlignment(SwingConstants.CENTER);
        }
        return delegate.getTableCellRendererComponent(table, 
                HeaderAsPropertyRenderer.getText(value, row, column, columnsMsgParameters), 
                isSelected, hasFocus, row, column);
    }
    
    /**
     * 
     * @param table {@link JTable}
     */
    public static void setupDefaultRenderer(JTable table) {
        setupDefaultRenderer(table, null);
    }

    /**
     * @param table  {@link JTable}
     * @param columnsMsgParameters Double dimension array of column message parameters
     */
    public static void setupDefaultRenderer(JTable table, Object[][] columnsMsgParameters) {
        TableCellRenderer defaultRenderer = table.getTableHeader().getDefaultRenderer();
        HeaderAsPropertyRendererWrapper newRenderer = new HeaderAsPropertyRendererWrapper(defaultRenderer, columnsMsgParameters);
        table.getTableHeader().setDefaultRenderer(newRenderer);
    }

}
