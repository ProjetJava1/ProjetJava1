package GUI;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.table.AbstractTableModel;

public class ResultSetTableModel extends AbstractTableModel
{
    public ResultSetTableModel( ResultSet resultSet )
    {
        this.resultSet = resultSet;

        try
        {
            this.resultSetMetaData = resultSet.getMetaData();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
    @Override
    public int getColumnCount()
    {
        try
        {
            return resultSetMetaData.getColumnCount();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int getRowCount()
    {
        try
        {
            resultSet.last();
            return resultSet.getRow();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex)
    {
        try
        {
            resultSet.absolute( rowIndex + 1 );
            return resultSet.getObject(columnIndex + 1 );
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String getColumnName( int column )
    {
        try
        {
            return resultSetMetaData.getColumnName( column + 1 );
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            return "";
        }
    }
    private ResultSet resultSet;
    private ResultSetMetaData resultSetMetaData;

}
