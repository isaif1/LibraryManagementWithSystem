package com.library.dao;


import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.library.entities.Books;


public interface BookRepository extends CrudRepository<Books,Integer>{
public Books findById(int id);

@Query(value = "select * from books where books.title= :title AND books.author_author_id=(SELECT B.author_id FROM authors AS B WHERE B.first_name= :firstName AND B.second_name= :secondName)",nativeQuery = true)
public Books findThisBook(@Param("title") String title,@Param("firstName") String firstName,@Param("secondName") String secondName);

@Modifying
@Transactional
@Query
(value = "UPDATE books as A SET A.available_copy=A.available_copy+ :availableCopy WHERE A.id= :b",nativeQuery = true)
public void Update(@Param("b") int b,@Param("availableCopy") int availableCopy);


@Modifying
@Transactional
@Query
(value = "UPDATE books as A SET A.available_copy=A.available_copy-1 WHERE A.id= :b",nativeQuery = true)
public void Borrow(@Param("b") int b);


@Modifying
@Transactional
@Query
(value = "UPDATE books as A SET A.available_copy=A.available_copy+1 WHERE A.id= :b",nativeQuery = true)
public void Return(@Param("b") int b);

}