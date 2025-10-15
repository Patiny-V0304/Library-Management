package com.ptit.librarymanagement.service;

import com.ptit.librarymanagement.context.dao.DAOFactory;
import com.ptit.librarymanagement.dao.BookDAO;
import com.ptit.librarymanagement.dao.ShelfDAO;
import com.ptit.librarymanagement.dto.BookDTO;
import com.ptit.librarymanagement.dto.ShelfDTO;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;

//@RequiredArgsConstructor
public class ShelfService {

    private final ShelfDAO shelfDAO;
    private final BookDAO bookDAO;

    public ShelfService(Connection connection) {
        this.shelfDAO = new ShelfDAO(connection);
        this.bookDAO = new BookDAO(connection);
    }

    public ShelfService(DAOFactory daoFactory) {
        this.shelfDAO = daoFactory.getShelfDAO();
        this.bookDAO = daoFactory.getBookDAO();
    }

    public List<BookDTO> getBookOfShelf (Integer id) {
        return bookDAO.getBookOfShelf(id);
    }

    public List<ShelfDTO> getAllShelves () {
        return shelfDAO.getAllShelves();
    }



    public Integer createShelf(ShelfDTO shelfDTO) {
        if (shelfDTO.getShelfName() == null || shelfDTO.getShelfName().trim().isEmpty()) {
            throw new IllegalArgumentException("Shelf name cannot be empty.");
        }
        return shelfDAO.insertShelf(shelfDTO);
    }

    public List<ShelfDTO> findAllShelves() {
        return shelfDAO.getAllShelves();
    }

    public Optional<ShelfDTO> findShelfDetailsById(int id) {
        return shelfDAO.getShelfByIdWithBooks(id);
    }

    public ShelfDTO getShelfById(int id) {
        return shelfDAO.getShelfById(id).orElseThrow();
    }

    public boolean updateShelfDetails(ShelfDTO shelfDTO) {
        if (shelfDTO.getId() == null || shelfDAO.getShelfById(shelfDTO.getId()).isEmpty()) {
            return false; // Kệ sách không tồn tại
        }
        return shelfDAO.updateShelf(shelfDTO);
    }

    public boolean removeShelf(int id) {
        Optional<ShelfDTO> shelfDetails = findShelfDetailsById(id);

        if (shelfDetails.isPresent() && shelfDetails.get().getBooks() != null && !shelfDetails.get().getBooks().isEmpty()) {
            throw new IllegalStateException("Cannot delete shelf ID " + id + ". There are still books on this shelf.");
        }

        return shelfDAO.deleteShelf(id);
    }
    public void deleteBookInShelf (BookDTO bookDTO) {
        shelfDAO.deleteBookInShelf(bookDTO);
    }



    public List<ShelfDTO> getShelfByIdOrNameOrLocation (ShelfDTO shelf) {
        return shelfDAO.getShelfByIdOrNameOrLocation(shelf);
    }
}
