# Show Tracker Service

very basic web service for creating table rows with id|title|episode information. also supports GET by id, title, PUT by id, [new title, episode], and POST by title, [optional episode].

# Routes

* GET     /show-tracker/get/all

get all shows

* GET     /show-tracker/get/{id}

get a show by its index id

* GET     /show-tracker/get-by-title/{title}

get a show by its title, returns a show or not found

* POST    /show-tracker/create

a new show is created by specifying a title and optionally the new episode value

* PUT     /show-tracker/change

update operations are done by specifying the id and the new title and episode values


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

# History

Feb. 8: Grand release of 1.0
