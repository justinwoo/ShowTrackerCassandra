# Show Tracker Service

very basic web service for creating table rows with id|title|episode information. also supports GET by id, title, PUT by id, [new title, episode], and POST by title, [optional episode].

# Routes

* GET     /shows

get all shows

* GET     /shows

get a show by its index id

* GET     /shows/title/{title}

get a show by its title, returns a show or not found

* POST    /shows

a new show is created by specifying a title new episode value (id will be generated)

* PUT     /shows/{id}

update operations are done by specifying the id and the new title and episode values


# Prerequisites

* maven
* java
* cassandra

# Setup

	CREATE TABLE shows
	(
        id text PRIMARY KEY,
        title text,
        episode int
	)


# Running

![run config](http://media-cache-ak0.pinimg.com/originals/e1/15/22/e115221937c8ef192cdbe243eab83a81.jpg "intellij")

or `java -jar **path-to-jar** server **path-to-yml**`
