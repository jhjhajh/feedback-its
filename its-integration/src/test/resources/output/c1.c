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
            "name": "x",
            "primed": true,
            "line": 5
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
            "name": "y",
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
          "name": "y",
          "primed": false,
          "line": 0
        },
        "val1": {
          "name": "+",
          "args": [
            {
              "value": "5",
              "line": 5,
              "tokentype": "Constant"
            },
            {
              "name": "x",
              "primed": true,
              "line": 5,
              "tokentype": "Variable"
            }
          ],
          "line": 5,
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
              "name": "x",
              "primed": true,
              "line": 5,
              "tokentype": "Variable"
            }
          ],
          "line": 0,
          "tokentype": "Operation"
        },
        "valueArray": [
          {
            "name": "y",
            "primed": false,
            "line": 0
          },
          {
            "name": "+",
            "args": [
              {
                "value": "5",
                "line": 5,
                "tokentype": "Constant"
              },
              {
                "name": "x",
                "primed": true,
                "line": 5,
                "tokentype": "Variable"
              }
            ],
            "line": 5
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
                "name": "x",
                "primed": true,
                "line": 5,
                "tokentype": "Variable"
              }
            ],
            "line": 0
          }
        ],
        "valueList": [
          {
            "name": "y",
            "primed": false,
            "line": 0
          },
          {
            "name": "+",
            "args": [
              {
                "value": "5",
                "line": 5,
                "tokentype": "Constant"
              },
              {
                "name": "x",
                "primed": true,
                "line": 5,
                "tokentype": "Variable"
              }
            ],
            "line": 5
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
                "name": "x",
                "primed": true,
                "line": 5,
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