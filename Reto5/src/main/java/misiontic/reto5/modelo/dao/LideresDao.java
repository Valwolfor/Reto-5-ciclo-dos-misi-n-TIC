
package misiontic.reto5.modelo.dao;

//Mostras una lista de líderes con nombre total y ordenados por ciudad de residencia

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import misiontic.reto5.modelo.vo.LideresVo;
import misiontic.reto5.utilities.Utilities;

public class LideresDao {
    //Constructor que recibe los valores de los objetos y los convierte en lista de objetos.
    public List<LideresVo> listar () throws SQLException{
      //se crea el array de objetos
      List<LideresVo> objListaLideres = new ArrayList<>();
      //se intancia la conexión con utilities
      Connection conn = Utilities.getConnection();
      //Se declaran los datos con la statement y result set, no se prepare porque no se necesita precompilar la sentencia.
        Statement stm = null;
        ResultSet rs = null;
        String sql = "SELECT ID_Lider, Nombre||' ' ||Primer_Apellido||' '||Segundo_Apellido AS Lider, Ciudad_Residencia FROM Lider ORDER By Ciudad_Residencia";
        //Se intancia y ejecutan ordenes
        try {
            //si fuera preparada se debería setear el elemento que se quede como valor de ingreso.(pstm.setDouble(1, limite);)
            stm = conn.createStatement();
            rs = stm.executeQuery(sql);
            //un ciclo while para ingresar los valores en el array list
            while(rs.next()){
                //se crea objeto de VO, para que recoja los valores y luego esto se adiere al array
                LideresVo lvo = new LideresVo();
                lvo.setLider(rs.getString("Lider")); //se usa el método de set y get para acomodar formatos y tomar la columna en rs.
                lvo.setCiudadResidencia(rs.getString("Ciudad_Residencia"));
                objListaLideres.add(lvo);
            }
        } catch (Exception e) {
            System.out.println("Error dao líderes: "+ e.getMessage());
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
        return objListaLideres; 
    }
}
