package speedmentpojo.localhost.db0.web1.test;

import com.speedment.Entity;
import com.speedment.field.ComparableField;
import com.speedment.field.StringField;
import com.speedment.internal.core.field.ComparableFieldImpl;
import com.speedment.internal.core.field.StringFieldImpl;
import java.util.Optional;
import javax.annotation.Generated;

/**
 * An interface representing an entity (for example, a row) in the Table
 * 'localhost.db0.web1.test'.
 * <p>
 * This Class or Interface has been automatically generated by Speedment. Any
 * changes made to this Class or Interface will be overwritten.
 * 
 * @author Speedment
 */
@Generated("Speedment")
public interface Test extends Entity<Test> {
    
    /**
     * This Field corresponds to the {@link Test} field that can be obtained
     * using the {@link Test#getId()} method.
     */
    public final static ComparableField<Test, Integer> ID = new ComparableFieldImpl<>("id", Test::getId, Test::setId);
    /**
     * This Field corresponds to the {@link Test} field that can be obtained
     * using the {@link Test#getSex()} method.
     */
    public final static StringField<Test> SEX = new StringFieldImpl<>("sex", o -> o.getSex().orElse(null), Test::setSex);
    
    /**
     * Returns the id of this Test. The id field corresponds to the database
     * column db0.web1.test.id.
     * 
     * @return the id of this Test
     */
    Integer getId();
    
    /**
     * Returns the sex of this Test. The sex field corresponds to the database
     * column db0.web1.test.sex.
     * 
     * @return the sex of this Test
     */
    Optional<String> getSex();
    
    /**
     * Sets the id of this Test. The id field corresponds to the database column
     * db0.web1.test.id.
     * 
     * @param id to set of this Test
     * @return this Test instance
     */
    Test setId(Integer id);
    
    /**
     * Sets the sex of this Test. The sex field corresponds to the database
     * column db0.web1.test.sex.
     * 
     * @param sex to set of this Test
     * @return this Test instance
     */
    Test setSex(String sex);
}