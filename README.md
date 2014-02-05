# Show Tracker Service

very basic web service for creating table rows with id|title|episode information. also supports GET by id, title, PUT by id, [new title, episode], and POST by title, [optional episode].

# Prerequisites

* maven
* java
* postgresql

# Setup

	-- Table: shows
	
	-- DROP TABLE shows;
	
	CREATE TABLE shows
	(
	  id integer NOT NULL DEFAULT nextval('"Shows_id_seq"'::regclass),
	  title character varying NOT NULL,
	  episode integer NOT NULL DEFAULT 1,
	  CONSTRAINT "Shows_pkey" PRIMARY KEY (id),
	  CONSTRAINT "no same titles" UNIQUE (title)
	)
	WITH (
	  OIDS=FALSE
	);
	ALTER TABLE shows
	  OWNER TO "pg-user";
	COMMENT ON TABLE shows
	  IS 'for ShowTrackerService';


# Running

![run config](http://media-cache-ak0.pinimg.com/originals/e1/15/22/e115221937c8ef192cdbe243eab83a81.jpg "intellij")

or `java -jar **path-to-jar** server **path-to-yml**`
