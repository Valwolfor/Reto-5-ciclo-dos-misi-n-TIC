
package misiontic.reto5.controller;

import java.sql.SQLException;
import java.util.List;
import misiontic.reto5.modelo.dao.ComprasDao;
import misiontic.reto5.modelo.dao.LideresDao;
import misiontic.reto5.modelo.dao.ProyectoDao;
import misiontic.reto5.modelo.vo.*;


public class Controller {
    //se crean objetos de los dao para recibir la data. Final para no ser heredados
    private final ComprasDao objComprasDao;
    private final LideresDao objLideresDao;
    private final ProyectoDao objProyectoDao;
    
    public Controller(){
        //se instancian en el constructor. 
        objComprasDao = new ComprasDao();
        objLideresDao = new LideresDao();
        objProyectoDao = new ProyectoDao();
    }    
     //Métodos que utlizan los métodos de cada dao para listar los datos.

    public List<ComprasVo> listarCompras() throws SQLException {
        return objComprasDao.listar();
    }
    public List<LideresVo> listarLideres() throws SQLException {
        return objLideresDao.listar();
    }
    public List<ProyectoVo> listarProyecto() throws SQLException {
        return objProyectoDao.listar();
    }
    
    
}
