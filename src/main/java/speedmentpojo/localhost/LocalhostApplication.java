package speedmentpojo.localhost;

import com.speedment.internal.core.runtime.SpeedmentApplicationLifecycle;
import javax.annotation.Generated;
import speedmentpojo.localhost.db0.web1.book.impl.BookManagerImpl;
import speedmentpojo.localhost.db0.web1.person.impl.PersonManagerImpl;
import speedmentpojo.localhost.db0.web1.student.impl.StudentManagerImpl;
import speedmentpojo.localhost.db0.web1.test.impl.TestManagerImpl;
import speedmentpojo.localhost.db0.web1.user.impl.UserManagerImpl;

/**
 * A {@link
 * com.speedment.internal.core.runtime.SpeedmentApplicationLifecycle} class
 * for the {@link com.speedment.config.Project} named localhost.
 * <p>
 * This Class or Interface has been automatically generated by Speedment. Any
 * changes made to this Class or Interface will be overwritten.
 * 
 * @author Speedment
 */
@Generated("Speedment")
public class LocalhostApplication extends SpeedmentApplicationLifecycle<LocalhostApplication> {
    
    public LocalhostApplication() {
        setSpeedmentApplicationMetadata(new LocalhostApplicationMetadata());
    }
    
    @Override
    protected void onInit() {
        loadAndSetProject();
        put(new speedmentpojo.localhost.db0.web1.book.impl.BookManagerImpl(speedment));
        put(new speedmentpojo.localhost.db0.web1.person.impl.PersonManagerImpl(speedment));
        put(new speedmentpojo.localhost.db0.web1.student.impl.StudentManagerImpl(speedment));
        put(new speedmentpojo.localhost.db0.web1.test.impl.TestManagerImpl(speedment));
        put(new speedmentpojo.localhost.db0.web1.user.impl.UserManagerImpl(speedment));
        super.onInit();
    }
}