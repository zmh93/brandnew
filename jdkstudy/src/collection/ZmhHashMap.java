package collection;

import java.io.Serializable;
import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

public class ZmhHashMap<K, V> extends AbstractMap<K, V> implements Map<K, V>, Cloneable, Serializable {

    transient ZmhHashMap.Node<K, V>[] table;
    transient Set<Entry<K, V>>     entrySet;

    public V put(K key, V value) {
        return putVal(hash(key), key, value, false, true);
    }

    final V putVal(int hash, K key, V value, boolean onlyIfAbsent,
                   boolean evict) {
        Node<K,V>[] tab; Node<K,V> p; int n, i;
        if ((tab = table) == null || (n = tab.length) == 0) {
//            n = (tab=resize()).length;
        }
        return null;
    }

    static final int hash(Object var0) {
        int var1;
        return var0 == null ? 0 : (var1 = var0.hashCode()) ^ var1 >>> 16;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        return null;
    }

    @Override
    public V getOrDefault(Object key, V defaultValue) {
        return null;
    }

    @Override
    public void forEach(BiConsumer<? super K, ? super V> action) {

    }

    @Override
    public void replaceAll(BiFunction<? super K, ? super V, ? extends V> function) {

    }

    @Override
    public V putIfAbsent(K key, V value) {
        return null;
    }

    @Override
    public boolean remove(Object key, Object value) {
        return false;
    }

    @Override
    public boolean replace(K key, V oldValue, V newValue) {
        return false;
    }

    @Override
    public V replace(K key, V value) {
        return null;
    }

    @Override
    public V computeIfAbsent(K key, Function<? super K, ? extends V> mappingFunction) {
        return null;
    }

    @Override
    public V computeIfPresent(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction) {
        return null;
    }

    @Override
    public V compute(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction) {
        return null;
    }

    @Override
    public V merge(K key, V value, BiFunction<? super V, ? super V, ? extends V> remappingFunction) {
        return null;
    }

    static class Node<K, V> implements Map.Entry<K, V> {
        final int hash;
        final K   key;
        V                     value;
        ZmhHashMap.Node<K, V> next;

        Node(int var1, K var2, V var3, ZmhHashMap.Node<K, V> var4) {
            this.hash = var1;
            this.key = var2;
            this.value = var3;
            this.next = var4;
        }

        @Override
        public final K getKey() {
            return key;
        }

        @Override
        public final V getValue() {
            return value;
        }

        @Override
        public final V setValue(V var1) {
            V var2 = this.value;
            this.value = var1;
            return var2;
        }

        public final boolean equals(Object var1) {
            if (var1 == this) {
                return true;
            } else {
                if (var1 instanceof Map.Entry) {
                    Map.Entry var2 = (Map.Entry) var1;
                    if (Objects.equals(this.key, var2.getKey()) && Objects.equals(this.value, var2.getValue())) {
                        return true;
                    }
                }

                return false;
            }
        }
    }



}
