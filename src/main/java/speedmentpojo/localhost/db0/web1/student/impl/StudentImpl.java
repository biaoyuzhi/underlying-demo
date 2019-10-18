package speedmentpojo.localhost.db0.web1.student.impl;

import com.speedment.Speedment;
import com.speedment.internal.core.code.AbstractBaseEntity;
import java.util.Objects;
import java.util.Optional;
import java.util.StringJoiner;
import javax.annotation.Generated;
import speedmentpojo.localhost.db0.web1.student.Student;

/**
 * An implementation representing an entity (for example, a row) in the Table
 * 'localhost.db0.web1.student'.
 * <p>
 * This Class or Interface has been automatically generated by Speedment. Any
 * changes made to this Class or Interface will be overwritten.
 * 
 * @author Speedment
 */
@Generated("Speedment")
public final class StudentImpl extends AbstractBaseEntity<Student> implements Student {
    
    private Integer id;
    private String name;
    private String course;
    private Integer score;
    
    StudentImpl(Speedment speedment) {
        super(speedment);
    }
    
    public StudentImpl(Speedment speedment, final Student student) {
        super(speedment);
        setId(student.getId());
        student.getName().ifPresent(this::setName);
        student.getCourse().ifPresent(this::setCourse);
        student.getScore().ifPresent(this::setScore);
    }
    
    @Override
    public Integer getId() {
        return id;
    }
    
    @Override
    public Optional<String> getName() {
        return Optional.ofNullable(name);
    }
    
    @Override
    public Optional<String> getCourse() {
        return Optional.ofNullable(course);
    }
    
    @Override
    public Optional<Integer> getScore() {
        return Optional.ofNullable(score);
    }
    
    @Override
    public final StudentImpl setId(Integer id) {
        this.id = id;
        return this;
    }
    
    @Override
    public final StudentImpl setName(String name) {
        this.name = name;
        return this;
    }
    
    @Override
    public final StudentImpl setCourse(String course) {
        this.course = course;
        return this;
    }
    
    @Override
    public final StudentImpl setScore(Integer score) {
        this.score = score;
        return this;
    }
    
    @Override
    public Student copy() {
        return new StudentImpl(getSpeedment_(), this);
    }
    
    @Override
    public String toString() {
        final StringJoiner sj = new StringJoiner(", ", "{ ", " }");
        sj.add("id = "+Objects.toString(getId()));
        sj.add("name = "+Objects.toString(getName().orElse(null)));
        sj.add("course = "+Objects.toString(getCourse().orElse(null)));
        sj.add("score = "+Objects.toString(getScore().orElse(null)));
        return "StudentImpl "+sj.toString();
    }
    
    @Override
    public boolean equals(Object that) {
        if (this == that) { return true; }
        if (!(that instanceof Student)) { return false; }
        @SuppressWarnings("unchecked")
        final Student thatStudent = (Student)that;
        if (!Objects.equals(this.getId(), thatStudent.getId())) {return false; }
        if (!Objects.equals(this.getName(), thatStudent.getName())) {return false; }
        if (!Objects.equals(this.getCourse(), thatStudent.getCourse())) {return false; }
        if (!Objects.equals(this.getScore(), thatStudent.getScore())) {return false; }
        return true;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(getId());
        hash = 31 * hash + Objects.hashCode(getName());
        hash = 31 * hash + Objects.hashCode(getCourse());
        hash = 31 * hash + Objects.hashCode(getScore());
        return hash;
    }
    
    @Override
    public Class<Student> getEntityClass_() {
        return Student.class;
    }
}