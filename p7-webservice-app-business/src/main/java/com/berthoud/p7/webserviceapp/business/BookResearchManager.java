package com.berthoud.p7.webserviceapp.business;

import com.berthoud.p7.webserviceapp.consumer.contract.BookReferenceDAO;
import com.berthoud.p7.webserviceapp.model.entities.Book;
import com.berthoud.p7.webserviceapp.model.entities.BookReference;
import com.berthoud.p7.webserviceapp.model.entities.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BookResearchManager {

    @Autowired
    BookReferenceDAO bookReferenceDAO;


    public List<BookReference> findBookMultiParameters(String authorSurname, String titleElement, int librairyId, List<String> tags) {

        List<BookReference> bookReferenceList = new ArrayList<>();

        Set <String> tagsHashSet = convertListStringIntoSetString(tags);

        // 3 parameters
        if (authorSurname != "" && titleElement != "" && !tags.isEmpty()) {
            bookReferenceList = bookReferenceDAO.findBookReferenceByTagsAndTitleElementAndAuthor(tagsHashSet, tagsHashSet.size(), titleElement, authorSurname);
        }

        // 2 parameters
        else if (authorSurname != "" && titleElement != "" && tags.isEmpty()) {
            bookReferenceList = bookReferenceDAO.findByAuthorSurnameAndTitleContainsAllIgnoreCase(authorSurname, titleElement);
        } else if (authorSurname == "" && titleElement != "" && !tags.isEmpty()) {
            bookReferenceList = bookReferenceDAO.findBookReferenceByTagsAndTitleElement(tagsHashSet, tagsHashSet.size(), titleElement);
        } else if (authorSurname != "" && titleElement == "" && !tags.isEmpty()) {
            bookReferenceList = bookReferenceDAO.findBookReferenceByTagsAndAuthor(tagsHashSet, tagsHashSet.size(), authorSurname);
        }

        // only 1 parameter
        else if (authorSurname != "" && titleElement == "" && tags.isEmpty()) {
            bookReferenceList = bookReferenceDAO.findByAuthorSurnameIgnoreCase(authorSurname);
        } else if (authorSurname == "" && titleElement != "" && tags.isEmpty()) {
            bookReferenceList = bookReferenceDAO.findByTitleContainsIgnoreCase(titleElement);
        } else if (authorSurname == "" && titleElement == "" && !tags.isEmpty()) {
            bookReferenceList = bookReferenceDAO.findBookReferenceByTags(tagsHashSet, tagsHashSet.size());
        }

        // 0 parameter
        else {
            // THROW EXCEPTION
        }

        // Filter through librairy
        return filterBookReferenceListByLibrairy(bookReferenceList, librairyId);
    }


    public List<BookReference> filterBookReferenceListByLibrairy(List<BookReference> bookReferenceList, int librairyId) {

        if (librairyId != -1) {

            Iterator<BookReference> i = bookReferenceList.iterator();
            while (i.hasNext()) {
                BookReference br = i.next();

                int test = 0;
                Iterator<Book> j = br.getBooks().iterator();
                while (j.hasNext()) {
                    Book book = j.next();
                    if (book.getLibrairy().getId() == librairyId) {
                        test++;
                        break;
                    }
                }

                if (test == 0) {
                    i.remove();
                }
            }
        }
        return bookReferenceList;
    }


    public Set<Tag> convertListStringIntoSetTag(List<String> keywords) {

        Set<Tag> tagHashSet = new HashSet<Tag>();

        //create a tag for every keyword of the list:
        for (String s : keywords) {
            Tag newTag = new Tag();
            newTag.setName(s);

            // add the tag to the HashSet:
            tagHashSet.add(newTag);
        }

        return tagHashSet;
    }

    public Set<String> convertListStringIntoSetString(List<String> keywords) {
        return new HashSet<>(keywords);
    }


}
