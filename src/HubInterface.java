import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableModel; 

public class HubInterface {

	private final int windowWidth2 = 450;
	private final int windowHeight2 = 300;
	
	public HubInterface()
	{
		
		JFrame frame = new JFrame("Hub"); 
		
		JPanel panel = new JPanel();
		JButton joinLobby = new JButton("Join Lobby");
		JButton createLobby = new JButton("Create Lobby");
		
		joinLobby.setFocusable(false);
		createLobby.setFocusable(false);
		
		//test data
		
		String data[][]={ {"1","Andrei","0/3"},    
                {"2","Mihai","0/3"},    
                {"3","Razvan","0/3"}};    
		String column[]={"ID","Owner","No. of players"};  
		
		JTable jt=new JTable(data,column);    
		
		setCellsAlignment(jt, SwingConstants.CENTER);
		
		JScrollPane sp=new JScrollPane(jt);  
		panel.add(sp);
		frame.setLayout(null);
	
		frame.setBounds(500, 200, windowWidth2, windowHeight2); 
		
		panel.setBounds(0, 70, 450, 150);
		joinLobby.setBounds(95, 20, 110, 20);
		createLobby.setBounds(245, 20, 110, 20);
		frame.add(joinLobby);
		frame.add(createLobby);
		frame.add(panel);
		
		frame.setResizable(false);
		frame.setVisible(true); 
	}
	
	public static void setCellsAlignment(JTable table, int alignment)
    {
        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(alignment);

        TableModel tableModel = table.getModel();

        for (int columnIndex = 0; columnIndex < tableModel.getColumnCount(); columnIndex++)
        {
            table.getColumnModel().getColumn(columnIndex).setCellRenderer(rightRenderer);
        }
    }
	}

