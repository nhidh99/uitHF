using System.Collections;
using UnityEngine;

public class Basket : MonoBehaviour
{
    private Vector2 leftPosition = new Vector2(-4, -4);
    private Vector2 rightPosition = new Vector2(4, -4);

    // Update is called once per frame
    void Update()
    {
        if (Input.GetKeyDown(KeyCode.LeftArrow))
        {
            transform.position = leftPosition;
        }
        else if (Input.GetKeyDown(KeyCode.RightArrow))
        {
            transform.position = rightPosition;
        }
    }
}
