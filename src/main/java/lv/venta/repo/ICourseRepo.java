package lv.venta.repo;

import org.springframework.boot.autoconfigure.cache.CacheProperties.Couchbase;

import org.springframework.data.repository.CrudRepository;

public interface ICourseRepo extends CrudRepository<Couchbase, Long>{

}
