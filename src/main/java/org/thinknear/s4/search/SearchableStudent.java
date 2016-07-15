package org.thinknear.s4.search;

import org.springframework.data.elasticsearch.annotations.Document;
import org.thinknear.s4.domain.Student;

import java.io.Serializable;

/**
 * Created by raul on 7/14/16.
 */
@Document(indexName = "student")
public class SearchableStudent extends Student implements Serializable{

}
