#Pen
Pen is a writing tool, used for creating your Blog or book. It helps in publishing and maintaining states of your blogs and books.
(future : will start with a blog)

#Modules
user
    Helps create, retrieve, update and delete users of the system
roles
    Helps create, retrieve, update and delete roles of the system
user-role-mapping
    Helps create, retrieve, update and delete user and role mapping in the system
Article
    Helps create, retrieve, update and delete an article
Blog
    Helps create,retrieve,update and delete a blog
Article-blog mapping
    Helps create,retrieve,update and delete a mapping of articles and blogs
Article-user mapping
    Helps create,retrieve,update and delete a mapping of articles and users

#Module Architecture
A module has MVC Architecture, which means it has a model (A DB table or filesystem)
A Controller which exposes the APIs and invokes desired services
A view can be an HTML/json output
A unit test for the controller
A unit test for the service

