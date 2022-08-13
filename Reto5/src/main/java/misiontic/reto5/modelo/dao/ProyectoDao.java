
package misiontic.reto5.modelo.dao;

//Casas campestres en barranquilla, santa marta y cartagena

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import misiontic.reto5.modelo.vo.ProyectoVo;
import misiontic.reto5.utilities.Utilities;

public class ProyectoDao {
    public List<ProyectoVo> listar() throws SQLException{
        List<ProyectoVo> listaObjProyecto = new ArrayList<ProyectoVo>();
        Connection conn = Utilities.getConnection();
        Statement stm = null;
        ResultSet rs = null;
        String sql = "SELECT ID_Proyecto, Constructora, Numero_Habitaciones, Ciudad, Clasificacion FROM Proyecto WHERE Ciudad in ('Barranquilla', 'Santa Marta', 'Cartagena')GROUP BY  ID_Proyecto  HAVING  Clasificacion = 'Casa Campestre'";
        try {
            stm = conn.createStatement();
            rs = stm.executeQuery(sql);
            while(rs.next()){
                ProyectoVo pvo = new ProyectoVo();
                pvo.setIdProyecto(rs.getInt("ID_Proyecto"));
                pvo.setConstructora(rs.getString("Constructora"));
                pvo.setNumeroHabitaciones(rs.getDouble("Numero_Habitaciones"));
                pvo.setCiudad(rs.getString("Ciudad"));
                pvo.setClasificación(rs.getString("Clasificacion"));
                listaObjProyecto.add(pvo);
                
            }
        } catch (Exception e) {
            System.out.println("Error en Proyectos : "+  e.getMessage());
        }finally{
            if(rs != null){
                rs.close();
            }if(stm != null){
                stm.close();
            }if(conn != null){
                conn.close();
            }
        }
        
        return listaObjProyecto;
    }

   
    }
    

