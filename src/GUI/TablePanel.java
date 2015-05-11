/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;


public class TablePanel extends JPanel
{
  public TablePanel( TableModel model )
  {
    table = new JTable( model );
    
    setLayout( new BorderLayout() );
    add( new JScrollPane( table ), BorderLayout.CENTER );
    
    
  }
  private JTable table;
}
