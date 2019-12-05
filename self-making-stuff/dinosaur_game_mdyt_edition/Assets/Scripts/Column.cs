using UnityEngine;
using System.Collections;

public class Column : MonoBehaviour
{
    public void changeSprite(Sprite sprite)
    {
       transform.GetChild(0).GetComponent<SpriteRenderer>().sprite = sprite;
    }

    void OnTriggerEnter2D(Collider2D other)
    {
        if (other.GetComponent<Bird>() != null)
        {
            GameControl.instance.BirdScored();
        }
    }
}