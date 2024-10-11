import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Defines a library of selection methods on Collections.
 *
 * @author  Lanie Louque (lpl0007@auburn.edu)
 *
 */
public final class Selector {

/**
 * Can't instantiate this class.
 *
 * D O   N O T   C H A N G E   T H I S   C O N S T R U C T O R
 *
 */
    private Selector() { }


    /**
     * Returns the minimum value in the Collection coll as defined by the
     * Comparator comp. If either coll or comp is null, this method throws an
     * IllegalArgumentException. If coll is empty, this method throws a
     * NoSuchElementException. This method will not change coll in any way.
     *
     * @param coll    the Collection from which the minimum is selected
     * @param comp    the Comparator that defines the total order on T
     * @return        the minimum value in coll
     * @throws        IllegalArgumentException as per above
     * @throws        NoSuchElementException as per above
     */
    public static <T> T min(Collection<T> coll, Comparator<T> comp) {
        if(coll == null || comp == null) {throw new IllegalArgumentException();}
        if(coll.size() == 0) {throw new NoSuchElementException();}
        Iterator<T> iter = coll.iterator();
        T minimum = iter.next();
        for(int i = 1; i < coll.size(); i++) {
            T test = iter.next();
            if(comp.compare(test, minimum) < 0) {
               minimum = test;
            }
        }
        return minimum;
    }


    /**
     * Selects the maximum value in the Collection coll as defined by the
     * Comparator comp. If either coll or comp is null, this method throws an
     * IllegalArgumentException. If coll is empty, this method throws a
     * NoSuchElementException. This method will not change coll in any way.
     *
     * @param coll    the Collection from which the maximum is selected
     * @param comp    the Comparator that defines the total order on T
     * @return        the maximum value in coll
     * @throws        IllegalArgumentException as per above
     * @throws        NoSuchElementException as per above
     */
    public static <T> T max(Collection<T> coll, Comparator<T> comp) {
        if(coll == null || comp == null) {throw new IllegalArgumentException();}
        if(coll.size() == 0) {throw new NoSuchElementException();}
        Iterator<T> iter = coll.iterator();
        T maximum = iter.next();
        for(int i = 1; i < coll.size(); i++) {
            T test = iter.next();
            if(comp.compare(test, maximum) > 0) {
               maximum = test;
            }
        }
        return maximum;
    }


    /**
     * Selects the kth minimum value from the Collection coll as defined by the
     * Comparator comp. If either coll or comp is null, this method throws an
     * IllegalArgumentException. If coll is empty or if there is no kth minimum
     * value, this method throws a NoSuchElementException. This method will not
     * change coll in any way.
     *
     * @param coll    the Collection from which the kth minimum is selected
     * @param k       the k-selection value
     * @param comp    the Comparator that defines the total order on T
     * @return        the kth minimum value in coll
     * @throws        IllegalArgumentException as per above
     * @throws        NoSuchElementException as per above
     */
    public static <T> T kmin(Collection<T> coll, int k, Comparator<T> comp) {
        if(coll == null || comp == null) {throw new IllegalArgumentException();}
        if(coll.size() == 0 || k <= 0 || coll.size() < k) {throw new NoSuchElementException();}
        List<T> b = new ArrayList<T>(coll);
        java.util.Collections.sort(b, comp);
        Iterator<T> iter = b.iterator();
        T test1 = b.get(0);
        List<T> c = new ArrayList<T>();
        c.add(test1);
        for(int j = 1; j < b.size(); j++) {
            T test2 = b.get(j);
            if(test1.equals(test2)) {
               c.add(b.get(j));
            }
            test1 = test2;
        }
        if(c.size() < k) {
            throw new NoSuchElementException();
        }
        return c.get(k-1);
    }


    /**
     * Selects the kth maximum value from the Collection coll as defined by the
     * Comparator comp. If either coll or comp is null, this method throws an
     * IllegalArgumentException. If coll is empty or if there is no kth maximum
     * value, this method throws a NoSuchElementException. This method will not
     * change coll in any way.
     *
     * @param coll    the Collection from which the kth maximum is selected
     * @param k       the k-selection value
     * @param comp    the Comparator that defines the total order on T
     * @return        the kth maximum value in coll
     * @throws        IllegalArgumentException as per above
     * @throws        NoSuchElementException as per above
     */
    public static <T> T kmax(Collection<T> coll, int k, Comparator<T> comp) {
        if(coll == null || comp == null) {throw new IllegalArgumentException();}
        if(coll.size() == 0 || k <= 0 || coll.size() < k) {throw new NoSuchElementException();}
        List<T> b = new ArrayList<T>(coll);
        java.util.Collections.sort(b, comp);
        java.util.Collections.reverse(b);
        Iterator<T> iter = b.iterator();
        T test1 = b.get(0);
        List<T> c = new ArrayList<T>();
        c.add(test1);
        for(int j = 1; j < b.size(); j++) {
            T test2 = b.get(j);
            if(test1.equals(test2)) {
               c.add(b.get(j));
            }
            test1 = test2;
        }
        if(c.size() < k) {
            throw new NoSuchElementException();
        }
        return c.get(k-1);
    }


    /**
     * Returns a new Collection containing all the values in the Collection coll
     * that are greater than or equal to low and less than or equal to high, as
     * defined by the Comparator comp. The returned collection must contain only
     * these values and no others. The values low and high themselves do not have
     * to be in coll. Any duplicate values that are in coll must also be in the
     * returned Collection. If no values in coll fall into the specified range or
     * if coll is empty, this method throws a NoSuchElementException. If either
     * coll or comp is null, this method throws an IllegalArgumentException. This
     * method will not change coll in any way.
     *
     * @param coll    the Collection from which the range values are selected
     * @param low     the lower bound of the range
     * @param high    the upper bound of the range
     * @param comp    the Comparator that defines the total order on T
     * @return        a Collection of values between low and high
     * @throws        IllegalArgumentException as per above
     * @throws        NoSuchElementException as per above
     */
    public static <T> Collection<T> range(Collection<T> coll, T low, T high,
                                                      Comparator<T> comp) {
        if(coll == null || comp == null) {throw new IllegalArgumentException();}
        if(coll.size() == 0) {throw new NoSuchElementException();}
        Iterator<T> iter = coll.iterator();
        Collection<T> b = new ArrayList<T>();
        for(T item : coll) {
            if((comp.compare(item,low) >= 0) && (comp.compare(item,high) <= 0)) {
               b.add(item);
            }
        }
        if(b.size() == 0) {
            throw new NoSuchElementException();
        }
        return b;
    }


    /**
     * Returns the smallest value in the Collection coll that is greater than
     * or equal to key, as defined by the Comparator comp. The value of key
     * does not have to be in coll. If coll or comp is null, this method throws
     * an IllegalArgumentException. If coll is empty or if there is no
     * qualifying value, this method throws a NoSuchElementException. This
     * method will not change coll in any way.
     *
     * @param coll    the Collection from which the ceiling value is selected
     * @param key     the reference value
     * @param comp    the Comparator that defines the total order on T
     * @return        the ceiling value of key in coll
     * @throws        IllegalArgumentException as per above
     * @throws        NoSuchElementException as per above
     */
    public static <T> T ceiling(Collection<T> coll, T key, Comparator<T> comp) {
        if(coll == null || comp == null) {throw new IllegalArgumentException();}
        if(coll.size() == 0) {throw new NoSuchElementException();}
        Iterator<T> iter = coll.iterator();
        T c = key;
        boolean value = false;
        for(int i = 0; i < coll.size(); i++) {
            T test = iter.next();
            if(comp.compare(test, key) >= 0) {
               if((comp.compare(test, c) <= 0) ||  !value) {
                  c = test;
               }
               value = true;
            }
        }
        if(value) {
            return c;
        }
        throw new NoSuchElementException();
    }


    /**
     * Returns the largest value in the Collection coll that is less than
     * or equal to key, as defined by the Comparator comp. The value of key
     * does not have to be in coll. If coll or comp is null, this method throws
     * an IllegalArgumentException. If coll is empty or if there is no
     * qualifying value, this method throws a NoSuchElementException. This
     * method will not change coll in any way.
     *
     * @param coll    the Collection from which the floor value is selected
     * @param key     the reference value
     * @param comp    the Comparator that defines the total order on T
     * @return        the floor value of key in coll
     * @throws        IllegalArgumentException as per above
     * @throws        NoSuchElementException as per above
     */
    public static <T> T floor(Collection<T> coll, T key, Comparator<T> comp) {
        if(coll == null || comp == null) {throw new IllegalArgumentException();}
        if(coll.size() == 0) {throw new NoSuchElementException();}
        Iterator<T> iter = coll.iterator();
        T f = key;
        boolean value = false;
        for(int i = 0; i < coll.size(); i++) {
            T test = iter.next();
            if(comp.compare(test, key) <= 0) {
               if((comp.compare(test, f) >= 0) ||  !value) {
                  f = test;
               }
               value = true;
            }
        }
        if(value) {
            return f;
        }
        throw new NoSuchElementException();
    }
}
