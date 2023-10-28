workspace "Kwik" {
    !identifiers flat
    !docs text
    !adrs adr

    !constant SPRING_BOOT "Spring Boot"
    !constant VUE "Vue 3"
    !constant POSTGRES "Postgres"
    !constant MONGODB "MongoDB"
    !constant COMMUNICATION_REST "REST"
    !constant COMMUNICATION_GRPC "gRPC"
    !constant COMMUNICATION_GRAPHQL "GraphQL"

    model {
        group "Nocpah" {
            nocpah_partner = softwareSystem "Partner" "Handles generic data of a partner" tag_external {
                nocpah_partner_database = container "Partner Database" "Database" ${POSTGRES} tag_database,tag_postgres
                container "Partner API" "API" ${SPRING_BOOT} tag_backend_api,tag_spring_framework {
                    -> nocpah_partner_database "Uses"
                }
            }

            nocpah_auth = softwareSystem "Auth" "Authentication and authorization for any Nocpah user" tag_external {
                nocpah_auth_database = container "Auth Database" "Database" ${MONGODB} tag_database,tag_mongodb
                container "Auth API" "API" ${SPRING_BOOT} tag_backend_api,tag_spring_boot {
                    -> nocpah_auth_database "Uses"
                }
            }
        }

                 
        enterprise "Kwik" {
            user_manager = person "Manager"
            user_consumer = person "Consumer"
            
            kwik = softwareSystem "Kwik" "Product for restaurants' online menu" {
                group "Kwik Rules" {
                    !constant RULES_DB_DESC "Database for data specific from Kwik"
                    kwik_rules_db = container "Kwik Rules Database" ${RULES_DB_DESC} ${POSTGRES} tag_database,tag_postgres {
                        component "Write Schema" "Key" "Structured in a way efficent for applying business rules"
                        component "Read Schema" "Key" "Structured for any reading requirement"
                    }

                    !constant RULES_API_DESC "Contains and applies all business rules"
                    kwik_rules_api = container "Kwik Rules API" ${RULES_API_DESC} ${SPRING_BOOT} tag_backend_api,tag_spring_boot {
                        -> nocpah_partner "Fetches restaurant data from" ${COMMUNICATION_GRPC}
                        -> nocpah_auth "Authenticates through" ${COMMUNICATION_GRPC}
                        -> kwik_rules_db "Uses" 
                    }
                }

                !constant RESTAURANT_DESC "Menu, basket and checkout"
                kwik_restaurant = container "Restaurant" ${RESTAURANT_DESC} ${VUE} tag_frontend_spa,tag_vue {
                    user_consumer -> this "Buys through"
                    -> kwik_rules_api "Interacts with" ${COMMUNICATION_GRAPHQL}
                }

                !constant ADMIN_DESC "Business insights, menu CRUD, delivery configuration and styling"
                kwik_admin = container "Admin" ${ADMIN_DESC} ${VUE} tag_frontend_spa,tag_vue {
                    user_manager -> this "Configures and get insights from"
                    -> kwik_rules_api "Interacts with" ${COMMUNICATION_REST}
                    -> kwik_restaurant "Configures" ${COMMUNICATION_GRPC}
                }
            }
        }
    }

    views {
        systemLandscape kwik_landscape "Landscape" {
            title "Kwik Architecture"
            description "High level architecture for Kwik."
            include *
            autolayout lr
        }

        container kwik {
            title "Kwik"
            description "Sofware product from Nocpah for Restaurants to show and sell their food."
            include *
            autolayout lr
        }

        container nocpah_auth {
            title "Nocpah Auth Service"
            description "Authentication service for all products under Nocpah."
            include *
            autolayout lr
        }

        container nocpah_partner {
            title "Nocpah Partner Service"
            description "Service containing all data related to direct clients for Nocpah."
            include *
            autolayout lr
        }

        component kwik_rules_db {
            title "Kwik Rules Database"
            include *
            autolayout lr
        }

        styles {
            # Others
            element tag_external {
                background #918f8e
            }
            # Containers
            element tag_backend_api{
                shape "Hexagon"
            }
            element tag_frontend_spa {
                shape "WebBrowser"
            }
            element tag_database {
                shape "Cylinder"
            }
            # Technologies
            element tag_spring_framework {
                icon "theme/icon_spring_framework.png"
            }
            element tag_spring_boot {
                icon "theme/icon_spring_boot.png"
            }
            element tag_postgres {
                icon "theme/icon_postgres.png"
            }
            element tag_mongodb {
                icon "theme/icon_mongodb.png"
            }
            element tag_vue {
                icon "theme/icon_vue.png"
            }
        }

        theme default
    }

}

# element <tag> {
#     shape <Box|RoundedBox|Circle|Ellipse|Hexagon|Cylinder|Pipe|Person|Robot|Folder|WebBrowser|MobileDevicePortrait|MobileDeviceLandscape|Component>
#     icon <file|url>
#     width <integer>
#     height <integer>
#     background <#rrggbb>
#     color <#rrggbb>
#     colour <#rrggbb>
#     stroke <#rrggbb>
#     fontSize <integer>
#     border <solid|dashed|dotted>
#     opacity <integer: 0-100>
#     metadata <true|false>
#     description <true|false>
# }