# Star Wars Api - B2W Challange

#### A basic api that consumes swapi data to store information about films related to planets created in the project mongo database

Uses Spring boot - with MVC Rest structure
Consumes https://swapi.dev/

Endpoint

    /api/planets

### JSON representation

Here is a JSON representation of Api.

<!-- { "blockType": "resource",
"@type": "book",
"optionalProperties": [] } -->

```json
{
  "data": [
    {
      "id": "1xx",
      "name": "Hoth",
      "climate": "xxxx",
      "terrain": "xxxxxxx",
      "movies": [
        {
          "title": "The Empire Strikes Back",
          "director": "Irvin Kershner",
          "producer": "Gary Kurtz, Rick McCallum",
          "release_date": "1980-05-17",
          "episode_id": "5"
        }
      ]
    }
  ],
  "erros": null
}
```

# Create Planet

**URL** : `/api/planets/`

**Method** : `POST`

**Auth required** : No

**Permissions required** : None

**Data constraints**

Provide planet information.

```json
{
  "id": "1",
  "name": "Hoth",
  "climate": "xxxx",
  "terrain": "xxxxxxx"
}
```

## Success Response

**Code** : `201 CREATED`

# Show Planets

**URL** : `/api/planets/`

**Method** : `GET`

**Auth required** : No

**Permissions required** : None

## Success Response

**Code** : `200 OK`

**Content examples**


```json
{
    "data": [
        {
            "id": "1",
            "name": "Hoth",
            "climate": "xxxx",
            "terrain": "xxxxxxx",
            "movies": [
                {
                    "title": "The Empire Strikes Back",
                    "director": "Irvin Kershner",
                    "producer": "Gary Kurtz, Rick McCallum",
                    "release_date": "1980-05-17",
                    "episode_id": "5"
                }
            ]
        },
        {
            "id": "3",
            "name": "Dagobah",
            "climate": "xxxx",
            "terrain": "xxxxxxx",
            "movies": [
                {
                    "title": "The Empire Strikes Back",
                    "director": "Irvin Kershner",
                    "producer": "Gary Kurtz, Rick McCallum",
                    "release_date": "1980-05-17",
                    "episode_id": "5"
                },
                {
                    "title": "Return of the Jedi",
                    "director": "Richard Marquand",
                    "producer": "Howard G. Kazanjian, George Lucas, Rick McCallum",
                    "release_date": "1983-05-25",
                    "episode_id": "6"
                },
                {
                    "title": "Revenge of the Sith",
                    "director": "George Lucas",
                    "producer": "Rick McCallum",
                    "release_date": "2005-05-19",
                    "episode_id": "3"
                }
            ]
        }
    ],
    "erros": null
}
```

# Show Planet

**URL** : `/api/planets/{id}`

**Query Params** : `name`

**Method** : `GET`

**Auth required** : No

**Permissions required** : None

## Success Response

**Code** : `200 OK`

**Content examples**


```json
{
    "data": [
        {
            "id": "1",
            "name": "Hoth",
            "climate": "xxxx",
            "terrain": "xxxxxxx",
            "movies": [
                {
                    "title": "The Empire Strikes Back",
                    "director": "Irvin Kershner",
                    "producer": "Gary Kurtz, Rick McCallum",
                    "release_date": "1980-05-17",
                    "episode_id": "5"
                }
            ]
        }
    ],
    "erros": null
}
```
## Error Responses

**Condition** : If there was no Account available to delete.

**Code** : `404 NOT FOUND`

**Content** : `{}`


# Delete Planet

Delete the Account of the Authenticated User if they are Owner.

**URL** : `/api/accounts/{id}`

**URL Parameters** : `id=[integer]` where `id` is the ID of the Planet in the
database.

**Method** : `DELETE`

**Auth required** : No

**Permissions required** : None

**Data** : `{}`

## Success Response

**Condition** : If the Account exists.

**Code** : `204 OK`

**Content** : `{}`

## Error Responses

**Condition** : If there was no Account available to delete.

**Code** : `404 NOT FOUND`

**Content** : `{}`