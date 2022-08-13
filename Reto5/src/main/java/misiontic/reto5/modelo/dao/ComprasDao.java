
package misiontic.reto5.modelo.dao;

//Compras salento

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import misiontic.reto5.modelo.vo.ComprasVo;
import misiontic.reto5.utilities.Utilities;

public class ComprasDao {
    public List<ComprasVo> listar() throws SQLException{
        List<ComprasVo> listaObjCompras = new ArrayList<ComprasVo>();
        Connection conn = Utilities.getConnection();
        Statement stm = null;
        ResultSet rs = null;
        String sql = "SELECT C.ID_Compra, P.Constructora, P.Banco_Vinculado FROM Compra AS C INNER JOIN Proyecto AS P WHERE Ciudad = 'Salento'GROUP BY ID_Compra HAVING Proveedor = 'Homecenter'";
        try {
            stm = conn.createStatement();
            rs = stm.executeQuery(sql);
            while(rs.next()){
               ComprasVo cvo = new ComprasVo(); 
               cvo.setIdCompra(rs.getInt("ID_Compra"));
               cvo.setConstructora(rs.getString("Constructora"));
               cvo.setBancoVinculado(rs.getString("Banco_Vinculado"));
               listaObjCompras.add(cvo);
            }
            
            
        } catch (Exception e) {
             System.out.println("Error dao Compras: "+ e.getMessage());
        }finally{
            if(rs != null){
                rs.close();
            }
            if(stm != null){
                stm.close();
            }
            if(conn != null){
                conn.close();
            }
        }
        return listaObjCompras; 
    }
    
    
}
