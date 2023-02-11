{
  "localRepairs": [
    {
      "mapping": [
        [
          {
            "name": "a",
            "primed": false,
            "line": 5
          },
          {
            "name": "a",
            "primed": true,
            "line": 4
          }
        ],
        [
          {
            "name": "$ret",
            "primed": false,
            "line": 0
          },
          {
            "name": "$ret",
            "primed": false,
            "line": 0
          }
        ],
        [
          {
            "name": "$out",
            "primed": false,
            "line": 0
          },
          {
            "name": "$out",
            "primed": false,
            "line": 0
          }
        ],
        [
          {
            "name": "b",
            "primed": false,
            "line": 0
          },
          {
            "name": "b",
            "primed": false,
            "line": 0
          }
        ],
        [
          {
            "name": "$in",
            "primed": false,
            "line": 0
          },
          {
            "name": "$in",
            "primed": false,
            "line": 0
          }
        ]
      ],
      "cost": 1.0,
      "repairedVariable": {
        "val0": {
          "name": "b",
          "primed": false,
          "line": 0
        },
        "val1": {
          "name": "+",
          "args": [
            {
              "value": "5",
              "line": 4,
              "tokentype": "Constant"
            },
            {
              "name": "a",
              "primed": true,
              "line": 4,
              "tokentype": "Variable"
            }
          ],
          "line": 4,
          "tokentype": "Operation"
        },
        "val2": {
          "name": "+",
          "args": [
            {
              "value": "1",
              "line": 5,
              "tokentype": "Constant"
            },
            {
              "name": "a",
              "primed": true,
              "line": 4,
              "tokentype": "Variable"
            }
          ],
          "line": 0,
          "tokentype": "Operation"
        },
        "valueArray": [
          {
            "name": "b",
            "primed": false,
            "line": 0
          },
          {
            "name": "+",
            "args": [
              {
                "value": "5",
                "line": 4,
                "tokentype": "Constant"
              },
              {
                "name": "a",
                "primed": true,
                "line": 4,
                "tokentype": "Variable"
              }
            ],
            "line": 4
          },
          {
            "name": "+",
            "args": [
              {
                "value": "1",
                "line": 5,
                "tokentype": "Constant"
              },
              {
                "name": "a",
                "primed": true,
                "line": 4,
                "tokentype": "Variable"
              }
            ],
            "line": 0
          }
        ],
        "valueList": [
          {
            "name": "b",
            "primed": false,
            "line": 0
          },
          {
            "name": "+",
            "args": [
              {
                "value": "5",
                "line": 4,
                "tokentype": "Constant"
              },
              {
                "name": "a",
                "primed": true,
                "line": 4,
                "tokentype": "Variable"
              }
            ],
            "line": 4
          },
          {
            "name": "+",
            "args": [
              {
                "value": "1",
                "line": 5,
                "tokentype": "Constant"
              },
              {
                "name": "a",
                "primed": true,
                "line": 4,
                "tokentype": "Variable"
              }
            ],
            "line": 0
          }
        ]
      },
      "errorLocation": {
        "val0": 1,
        "val1": 1,
        "valueArray": [
          1,
          1
        ],
        "valueList": [
          1,
          1
        ]
      },
      "funcName": "main"
    }
  ]
}