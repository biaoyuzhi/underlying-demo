package speedmentpojo.localhost.db0.web1.book.impl;

import com.speedment.Speedment;
import com.speedment.internal.core.code.AbstractBaseEntity;
import java.util.Objects;
import java.util.Optional;
import java.util.StringJoiner;
import javax.annotation.Generated;
import speedmentpojo.localhost.db0.web1.book.Book;

/**
 * An implementation representing an entity (for example, a row) in the Table
 * 'localhost.db0.web1.book'.
 * <p>
 * This Class or Interface has been automatically generated by Speedment. Any
 * changes made to this Class or Interface will be overwritten.
 * 
 * @author Speedment
 */
@Generated("Speedment")
public final class BookImpl extends AbstractBaseEntity<Book> implements Book {
    
    private Integer id;
    private Double price;
    private String name;
    
    BookImpl(Speedment speedment) {
        super(speedment);
    }
    
    public BookImpl(Speedment speedment, final Book book) {
        super(speedment);
        setId(book.getId());
        book.getPrice().ifPresent(this::setPrice);
        book.getName().ifPresent(this::setName);
    }
    
    @Override
    public Integer getId() {
        return id;
    }
    
    @Override
    public Optional<Double> getPrice() {
        return Optional.ofNullable(price);
    }
    
    @Override
    public Optional<String> getName() {
        return Optional.ofNullable(name);
    }
    
    @Override
    public final BookImpl setId(Integer id) {
        this.id = id;
        return this;
    }
    
    @Override
    public final BookImpl setPrice(Double price) {
        this.price = price;
        return this;
    }
    
    @Override
    public final BookImpl setName(String name) {
        this.name = name;
        return this;
    }
    
    @Override
    public Book copy() {
        return new BookImpl(getSpeedment_(), this);
    }
    
    @Override
    public String toString() {
        final StringJoiner sj = new StringJoiner(", ", "{ ", " }");
        sj.add("id = "+Objects.toString(getId()));
        sj.add("price = "+Objects.toString(getPrice().orElse(null)));
        sj.add("name = "+Objects.toString(getName().orElse(null)));
        return "BookImpl "+sj.toString();
    }
    
    @Override
    public boolean equals(Object that) {
        if (this == that) { return true; }
        if (!(that instanceof Book)) { return false; }
        @SuppressWarnings("unchecked")
        final Book thatBook = (Book)that;
        if (!Objects.equals(this.getId(), thatBook.getId())) {return false; }
        if (!Objects.equals(this.getPrice(), thatBook.getPrice())) {return false; }
        if (!Objects.equals(this.getName(), thatBook.getName())) {return false; }
        return true;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(getId());
        hash = 31 * hash + Objects.hashCode(getPrice());
        hash = 31 * hash + Objects.hashCode(getName());
        return hash;
    }
    
    @Override
    public Class<Book> getEntityClass_() {
        return Book.class;
    }
}