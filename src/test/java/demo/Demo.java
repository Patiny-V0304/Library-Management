package demo;

import com.ptit.librarymanagement.common.dbutils.DbConnection;
import com.ptit.librarymanagement.common.enums.Role;
import com.ptit.librarymanagement.context.dao.BaseDAOFactory;
import com.ptit.librarymanagement.context.dao.DAOFactory;
import com.ptit.librarymanagement.context.service.BaseServiceFactory;
import com.ptit.librarymanagement.context.service.ServiceFactory;
import com.ptit.librarymanagement.dto.AccountDTO;
import com.ptit.librarymanagement.service.AccountService;

import java.util.Optional;

public class Demo {
    static ServiceFactory  serviceFactory = new BaseServiceFactory(DbConnection.getConnection());
    static DAOFactory daoFactory = new BaseDAOFactory(DbConnection.getConnection());

    public static void main(String[] args) {
        Optional<AccountDTO> uuu = daoFactory.getAccountDAO().getAccountByEmail("nguyenvanan@library.com");
        System.out.println();
    }
}
